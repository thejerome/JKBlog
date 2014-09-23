package com.efimchick.jkblog.dao.mock;

import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Person;
import com.efimchick.jkblog.domain.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Jerome on 16.04.2014.
 */

@Repository
@Qualifier("mockArticleDao")
public class ArticleDaoMock implements ArticleDao {

    @Override
    public Article findById(Long id) {
        return findArticle(a -> a.getId().equals(id));
    }

    @Override
    public List<Article> findAll(int pageNumber, int perPage) {
        return findArticles(a -> true);
    }

    @Override
    public List<Article> findAllByTags(List<Tag> tags, int pageNumber, int perPage) {
        return findArticles(a -> a.getTags().containsAll(tags));
    }

    @Override
    public List<Article> findAllByAuthor(Person person, int pageNumber, int perPage) {
        return findArticles(a -> a.getAuthor().equals(person));
    }

    @Override
    public Article save(Article article) {
        synchronized (articles()) {
            delete(findById(article.getId()));
            articles().add(article);
        }
        return article;
    }

    @Override
    public void delete(Article article) {
        articles().remove(article);
    }

    private List<Article> articles() {
        return MockModel.instance.articles;
    }


    private Article findArticle(Predicate<Article> predicate) {
        return articles().stream().filter(predicate).findFirst().orElse(null);
    }

    private List<Article> findArticles(Predicate<Article> predicate) {
        return articles().stream().filter(predicate).collect(Collectors.toList());
    }
}
