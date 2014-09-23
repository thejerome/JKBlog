package com.efimchick.jkblog;

import com.efimchick.jkblog.services.ArticleService;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: efimchick
 * Date: 11.10.13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
public class SpringDataJpaTesting {

    @Transactional
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
        context.refresh();


        ArticleService articleService = (ArticleService) context.getBean("springJpaArticleService");

        System.out.println(articleService.listArticles());
        System.out.println(articleService.listArticlesByTitle("Test Article"));

/*
        ArticleRepository articleRepository = (ArticleRepository) context.getBean("articleRepository");
        System.out.println(articleRepository.findAll());


*/
    }
}
