package com.efimchick.jkblog.controllers;


import archive.repository.mysql.ArticleRepository;
import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.dao.PersonDao;
import com.efimchick.jkblog.dao.TagDao;
import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.services.ArticleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jerome on 09.12.13.
 */


@Controller
public class BlogController {

    private final static  Integer ARTICLE_PER_PAGE = 5;

    @Autowired
    @Qualifier("hibernateArticleDao")
    ArticleDao articleDao;

    @Autowired
    @Qualifier("hibernateTagDao")
    TagDao tagDao;


    @Autowired
    @Qualifier("hibernatePersonDao")
    PersonDao personDao;

    @RequestMapping("/list")
    public String listArticles(ModelMap model) {
        return "redirect:/list/1";
    }

    @RequestMapping("/list/{page}")
     public String listArticles(ModelMap model, @PathVariable String  page) {

        Integer pageNumber = 1;
        try{
            pageNumber = Integer.valueOf(page);
        } finally {
            System.out.println("page = " + page);
        }
        model.addAttribute("message", "mess");
        model.addAttribute("articleList", articleDao.findAll(pageNumber, ARTICLE_PER_PAGE));

        System.out.println(articleDao.findAll(pageNumber, ARTICLE_PER_PAGE));
        System.out.println(model);

        return "index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/list";
    }
}