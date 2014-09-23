package com.efimchick.jkblog.dao.hibernate;

import com.efimchick.jkblog.dao.TagDao;
import com.efimchick.jkblog.domain.Person;
import com.efimchick.jkblog.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;


import java.util.List;

import static com.efimchick.jkblog.dao.hibernate.HibernateUtils.closeEntityManager;

/**
 * Created by Jerome on 23.07.2014.
 */
@Repository
@Service("hibernateTagDao")
@Transactional
public class HibernateTagDao implements TagDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Tag findById(Long id) {
        return em.find(Tag.class, id);
    }

    @Override
    public Tag save(Tag tag) {
        if(tag.getId() == null){
            em.persist(tag);
        } else {
            em.merge(tag);
        }
        return tag;
    }

    @Override
    public void delete(Tag tag) {
        findAllByParent(tag).forEach(t ->
        {
            t.setParent(null);
            save(t);
        });
        em.remove(em.merge(tag));
    }

    @Override
    public List<Tag> findAll(int pageNumber, int perPage) {
        return em.createNamedQuery("Tag.findAll").getResultList();
    }

    @Override
    public Tag findByName(String name) {
        return (Tag) em.createNamedQuery("Tag.findByName")
                .setParameter("name", name)
                .getSingleResult();

    }

    @Override
    public List<Tag> findAllByParent(Tag parent) {
        return  em.createNamedQuery("Tag.findAllByParent")
                .setParameter("id", parent.getId())
                .getResultList();
    }
}
