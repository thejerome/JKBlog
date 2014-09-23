package archive.repository.sql.specs

import archive.repository.sql.QueryWhereSpecification
import archive.repository.sql.SqlClause
import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */
@Canonical
class ById implements QueryWhereSpecification {

    final long id;
    @Override
    SqlClause toSqlClause() {
        return new SqlClause("id = :id", ["id": id])
    }
}
