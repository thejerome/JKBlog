package archive.repository.sql;

import archive.repository.QuerySpecification;
import archive.repository.sql.SqlClause;

/**
 * Created by Jerome on 24.04.2014.
 */
public interface SqlSpecification extends QuerySpecification{
    SqlClause toSqlClause();
}
