package com.efimchick.jkblog;


import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.dao.PersonDao;
import com.efimchick.jkblog.domain.Article;
import com.efimchick.jkblog.domain.Tag;
import com.google.common.collect.ComparisonChain;
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
public class HibernateTesting {

    @Transactional
    public static void main(String[] args) {
        /*GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("db.xml");
        context.refresh();

        ArticleDao articleDao = context.getBean("hibernateArticleDao", ArticleDao.class);
        //PersonDao personDao = context.getBean("personDao", PersonDao.class);
        System.out.println(articleDao.findAll());

        Article some = Article.empty("newWorld");
        //some.setAuthor(personDao.findById(1l));
        articleDao.save(some);
        System.out.println(articleDao.findAll(0,0));

        //some.getAuthor().setLastname("Param");
        //personDao.save(some.getAuthor());
        Article article = articleDao.findById(1l);

        articleDao.save(some);
        System.out.println(articleDao.findAll(0,0));
        System.out.println();
        System.out.println(articleDao.findAll(1,1));
        System.out.println(articleDao.findAll(2,1));
        System.out.println(articleDao.findAllByAuthor(article.getAuthor()));
        System.out.println(articleDao.findAllByAuthor(article.getAuthor(), 1, 1));
        System.out.println(articleDao.findAllByTags(article.getTags()));
        System.out.println(articleDao.findAllByTags(article.getTags(), 1, 1));
        System.out.println();


       // System.out.println(articleDao.findAll().stream().count());
*/

/*


        Closure2<Integer, Integer> adder = closure(Integer.class, Integer.class);{
            of(HibernateTesting.class).sum(var(Integer.class), var(Integer.class));
        }

        Integer res = (Integer) adder.apply(2,3);
        //println.apply(res);

        checkNotNull(adder);

        ComparisonChain.start().compare(1,2).compareTrueFirst(true,false).result();

*/

/*
        some.setContent("42");
        articleDao.save(some);
        System.out.println(articleDao.findAll());

        articleDao.save(new Article("pam", "pam"));
        System.out.println(articleDao.findAll());
*/


    }
}
