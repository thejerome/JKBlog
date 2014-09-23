package archive.repository.mysql;

import archive.model.Person;
import archive.model.Role;
import archive.repository.QuerySpecification;
import archive.repository.Repository;
import archive.repository.RepositoryException;
import archive.repository.sql.SqlSpecificationsProcessor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.*;
import static archive.repository.mysql.datasource.DataSource.*;

/**
 * Created by Jerome on 16.06.2014.
 */
public class PersonRepository implements Repository<Person> {

    @Override
    public void add(Person element) throws RepositoryException {

    }

    @Override
    public void remove(Person element) throws RepositoryException {

    }

    @Override
    public void update(Person element) throws RepositoryException {

    }

    @Override
    public List<Person> query(QuerySpecification... specifications) {

        String sql = "select * from person p";
        SqlSpecificationsProcessor processor = new SqlSpecificationsProcessor(specifications);

        sql = processor.addToSql(sql);
        System.out.println("sql: " + sql);
        Map<String, Object> params = processor.getParams();
        System.out.println("params = " + params);


        List<Person> persons = new NamedParameterJdbcTemplate(dbContext.getBean("dataSource", DataSource.class)).query(
                sql,
                params,
                (rs, roNum) -> {
                    Person person = new Person();
                    person.setId(rs.getLong("id"));
                    person.setEmail(rs.getString("email"));
                    person.setName(rs.getString("firstname"));
                    person.setPassword(rs.getString("password"));
                    person.setRole(Role.empty(rs.getLong("role_id")));
                    return person;
                }
        );

        System.out.println("persons = " + persons);

        return persons;
    }
}
