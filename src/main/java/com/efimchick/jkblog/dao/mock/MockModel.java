package com.efimchick.jkblog.dao.mock;


import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Person;
import com.efimchick.jkblog.domain.Tag;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jerome on 16.04.2014.
 */
public class MockModel {

    static MockModel instance = new MockModel();

    public static void reset() {
        instance = new MockModel();
    }

    List<Tag> tags = new LinkedList<>();
    List<Person> persons = new LinkedList<>();
    List<Article> articles = new LinkedList<>();

    public MockModel() {
        ApplicationContext applicationContext = new GenericGroovyApplicationContext("classpath:modelTestsBeans.groovy");

        try {
            tags = lookupForBeans(applicationContext, Tag.class);
            persons = lookupForBeans(applicationContext, Person.class);
            articles = lookupForBeans(applicationContext, Article.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private <T> List<T> lookupForBeans(ApplicationContext applicationContext, Class<T> clazz) {
        return new ArrayList<>(applicationContext.getBeansOfType(clazz).values());
    }
}
