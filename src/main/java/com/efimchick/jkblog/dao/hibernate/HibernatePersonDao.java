package com.efimchick.jkblog.dao.hibernate;

import com.efimchick.jkblog.dao.PersonDao;
import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static com.efimchick.jkblog.dao.hibernate.HibernateUtils.closeEntityManager;

/**
 * Created by Jerome on 16.07.2014.
 */
@Repository
@Service("hibernatePersonDao")
@Transactional
public class HibernatePersonDao implements PersonDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public Person save(Person person) {
        if (person.getId() == null){
            em.persist(person);
        } else {
            em.merge(person);
        }
        return person;
    }

    @Override
    public void delete(Person person) {
        em.remove(em.merge(person));
    }

    @Override
    public List<Person> findAll(int pageNumber, int perPage) {
        return em.createNamedQuery("Person.findAll").getResultList();
    }
}
