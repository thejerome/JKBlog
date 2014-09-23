package com.efimchick.jkblog.dao.hibernate;


import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.dao.PersonDao;
import com.efimchick.jkblog.dao.TagDao;
import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Person;
import com.efimchick.jkblog.domain.Tag;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:db.xml")
public class HibernateDaoTest {

    @Autowired
    @Qualifier("hibernateArticleDao")
    ArticleDao articleDao;

    @Autowired
    @Qualifier("hibernateTagDao")
    TagDao tagDao;


    @Autowired
    @Qualifier("hibernatePersonDao")
    PersonDao personDao;


    @Test
    public void testFindById() throws Exception {
        Tag tag = tagDao.findById(1L);
        assertEquals(tag.getName(), "Java");

        Person person = personDao.findById(1L);
        assertEquals(person.getName(), "Jerome");


        Article article = articleDao.findById(1L);
        assertEquals(article.getTitle(), "Test Article");



    }

    @Test
     public void testPersist() throws Exception {
        Tag tag = new Tag();
        tag.setName("tag");
        Tag parentTag = new Tag();
        parentTag.setName("parent");

        tagDao.save(parentTag);
        tagDao.save(tag);

        tag.setParent(parentTag);
        tagDao.save(tag);
        assertEquals(4, tagDao.findAll().size());


        Person person = new Person();
        person.setName("testPerson");
        person.setEmail("some@fourtyone.com");
        person.setPassword("password");
        person.setRole(personDao.findById(1L).getRole());
        person = personDao.save(person);
        assertEquals(2, personDao.findAll().size());


        Article article = new Article();
        article.setAuthor(person);
        article.setTitle("anotherTestTitle");
        article.setContent("content");
        articleDao.save(article);
        article.addTag(tagDao.findById(tag.getId()));
        article = articleDao.save(article);

        assertEquals(4, articleDao.findAll().size());
        assertEquals(1, articleDao.findAllByAuthor(person).size());



        articleDao.delete(articleDao.findById(article.getId()));
        assertEquals(3, articleDao.findAll().size());
        assertEquals(0, articleDao.findAllByAuthor(person).size());


        personDao.delete(personDao.findById(person.getId()));
        assertEquals(personDao.findAll().size(), 1);

        tagDao.delete(parentTag);
        assertEquals(3, tagDao.findAll().size());

        tagDao.delete(parentTag);
        assertEquals(3, tagDao.findAll().size());

        tagDao.delete(tagDao.findByName(tag.getName()));
        assertEquals(2, tagDao.findAll().size());
    }


    @Test
    public void testFindAll() throws Exception {
        assertEquals(tagDao.findAll().size(), 2);
        assertEquals(personDao.findAll().size(), 1);
        assertEquals(articleDao.findAll().size(), 3);
    }

    @Test
    public void testAdvancedFinds() throws Exception {
        assertEquals(articleDao.findAllByAuthor(personDao.findById(1L)).size(), 3);
        assertEquals(articleDao.findAllByTags(tagDao.findAll()).size(), 1);
        assertEquals(articleDao.findAllByTags(new LinkedList<Tag>(){
            {add(tagDao.findByName("Java"));}
        }).get(0).getAuthor(), personDao.findAll().get(0));
    }
}