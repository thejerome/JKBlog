package archive.repository.mysql;

import archive.model.Article;
import archive.model.Person;
import archive.repository.QuerySpecification;
import archive.repository.Repository;
import archive.repository.RepositoryException;
import archive.repository.sql.SqlSpecificationsProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by Jerome on 24.04.2014.
 */
public class ArticleRepository implements Repository<Article> {

    @Autowired
    DataSource dataSource;

    @Required
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Article element) throws RepositoryException {

    }

    @Override
    public void remove(Article element) throws RepositoryException {

    }

    @Override
    public void update(Article element) throws RepositoryException {

    }

    @Override
    public List<Article> query(QuerySpecification... specifications) {
        SqlSpecificationsProcessor sqlSpecificationsProcessor = new SqlSpecificationsProcessor(specifications);
        String sql = sqlSpecificationsProcessor.addToSql("select * from Article");
        System.out.println("sql: " + sql);
        Map<String, Object> params = sqlSpecificationsProcessor.getParams();
        System.out.println("params = " + params);


        List<Article> articles = new NamedParameterJdbcTemplate(dataSource).query(
                sql,
                params,
                (rs, roNum) -> {
                    Article article = new Article();
                    article.setId(rs.getLong("id"));
                    article.setTitle(rs.getString("title"));
                    article.setContent(rs.getString("content"));
                    article.setCreated(getLocalDateTime(rs.getDate("created")));
                    article.setAuthor(Person.empty(rs.getLong("author_id")));
                    return article;
                }
        );

        System.out.println("articles = " + articles);

        return articles;
    }

    private LocalDateTime getLocalDateTime(Date date) throws SQLException {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }
}
