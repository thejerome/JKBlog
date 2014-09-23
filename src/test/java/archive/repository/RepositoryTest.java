package archive.repository;

import archive.model.Article;
import archive.repository.mysql.ArticleRepository;
import archive.repository.sql.CombinedWhereSpecification;
import archive.repository.sql.specs.*;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.List;

public class RepositoryTest {

    static ApplicationContext applicationContext;

    @BeforeClass
    public static void setUp() throws Exception {
        applicationContext = new GenericGroovyApplicationContext("classpath:repos.groovy");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testQuery() throws Exception {
        Repository<Article> repo = applicationContext.getBean(ArticleRepository.class);


        repo.query(
            new ById(2),
            new CombinedWhereSpecification(
                    CombinedWhereSpecification.getOR(),
                    new ByLike("title", "Java"),
                    new ByLike("content", "Java")
                    ),
            new Paging(5, 3),
            new OrderBy("created")
        );

        List<Article> allArticles = repo.query(
                new OrderBy("created")
        );

        System.out.println("allArticles = " + allArticles);


    }
}