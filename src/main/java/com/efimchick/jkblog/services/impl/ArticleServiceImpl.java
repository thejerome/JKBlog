package com.efimchick.jkblog.services.impl;



import com.efimchick.jkblog.services.ArticleService;
import com.efimchick.jkblog.domain.Article;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jerome on 09.12.13.
 */

@Service("springJpaArticleService")
@Repository
@Transactional
public class ArticleServiceImpl {
        //implements ArticleService {
/*
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public List<Article> listArticles() {
        return Lists.newLinkedList(articleRepository.findAll());
    }

    @Override
    @Transactional
    public List<Article> listArticlesByTitle(String title) {
        return Lists.newLinkedList(articleRepository.findByTitle(title));
    }

    @Override
    @Transactional
    public List<Article> listArticlesByTitleSample(String titleSample) {
        return Lists.newLinkedList(articleRepository.findAll());
    }
    */
}
