package com.efimchick.jkblog.dao;

import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Person;
import com.efimchick.jkblog.domain.Tag;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jerome on 16.04.2014.
 */


public interface ArticleDao extends Dao<Article> {
    List<Article> findAllByTags(List<Tag> tags, int pageNumber, int perPage);
    List<Article> findAllByAuthor(Person person, int pageNumber, int perPage);

    default List<Article> findAllByTags(List<Tag> tags){return findAllByTags(tags, 0,0);};
    default List<Article> findAllByAuthor(Person person){return findAllByAuthor(person, 0,0);};
}
