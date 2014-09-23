package archive.model;


import com.efimchick.jkblog.dao.ArticleDao;
import com.efimchick.jkblog.dao.mock.ArticleDaoMock;
import com.efimchick.jkblog.dao.mock.PersonDaoMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.time.LocalDateTime;


/**
 * Created by Jerome on 16.04.2014.
 */
public class ModelTests {

    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new GenericGroovyApplicationContext("classpath:modelTestsBeans.groovy");
    }

    @Test
    public void articleTest() throws Exception {
       /* ArticleDao articleDao = new ArticleDaoMock();
        assertEquals(articleDao.findAll().size(), 2);

        Article article = new Article();
        article.setId(3L);
        article.setAuthor(new PersonDaoMock().findById(1L));
        article.setTitle("title");
        article.setContent("Content");
        article.setCreated(LocalDateTime.now());

        articleDao.save(article);
        assertEquals(articleDao.findAll().size(), 3);*/
    }

    @Test
     public void simple2() throws Exception {

    }
}