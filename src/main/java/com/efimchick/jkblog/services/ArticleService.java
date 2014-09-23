package com.efimchick.jkblog.services;

import com.efimchick.jkblog.domain.Article;

import java.util.List;

/**
 * Created by Jerome on 09.12.13.
 */
public interface ArticleService {
        public List<Article> listArticles();
        public List<Article> listArticlesByTitle(String title);
        public List<Article> listArticlesByTitleSample(String titleSample);

}
