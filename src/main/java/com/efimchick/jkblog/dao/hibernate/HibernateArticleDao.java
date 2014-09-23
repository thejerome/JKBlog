package com.efimchick.jkblog.dao.hibernate;

import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.domain.Article;
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
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

import static com.efimchick.jkblog.dao.hibernate.HibernateUtils.applyPaging;
import static com.efimchick.jkblog.dao.hibernate.HibernateUtils.closeEntityManager;


/**
 * Created by Jerome on 15.07.2014.
 */

@Repository
@Service("hibernateArticleDao")
@Transactional
public class HibernateArticleDao implements ArticleDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    @Override
    public List<Article> findAll(int pageNumber, int perPage) {
        Query query = em.createNamedQuery("Article.findAll");
        applyPaging(pageNumber, perPage, query);
        return query.getResultList();
    }

    @Override
    public List<Article> findAllByTags(List<Tag> tags, int pageNumber, int perPage) {
        Query query = em.createNamedQuery("Article.findAllByTags");
        query.setParameter("ids", tags.stream().map(Tag::getId).collect(Collectors.toList()));
        applyPaging(pageNumber, perPage, query);
        return query.getResultList();
    }

    @Override
    public List<Article> findAllByAuthor(Person person, int pageNumber, int perPage) {
        Query query = em.createNamedQuery("Article.findByAuthor");
        query.setParameter("id", person.getId());
        applyPaging(pageNumber, perPage, query);
        return query.getResultList();
    }


    @Override
    public Article save(Article article) {
        if(article.getId() == null){
            em.persist(article);
        } else {
            em.merge(article);
        }
        return article;
    }

    @Override
    public void delete(Article article) {
        em.remove(em.merge(article));
    }


}

