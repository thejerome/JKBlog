package archive.repository

import org.junit.Before
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext

/**
 * Created by Jerome on 24.04.2014.
 */
class RepositoryTests extends GroovyTestCase {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new GenericGroovyApplicationContext("classpath:MySQLQuerySpecifications.groovy");
    }

    void tearDown() {

    }

    void testAdd() {

    }

    void testRemove() {

    }

    void testUpdate() {

    }

    void testQuery() {

    }
}
