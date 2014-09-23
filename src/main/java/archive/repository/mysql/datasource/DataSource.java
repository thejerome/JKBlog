package archive.repository.mysql.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Jerome on 16.06.2014.
 */
public class DataSource {
    public static ApplicationContext dbContext = new GenericXmlApplicationContext("classpath:spring-config.xml");
}
