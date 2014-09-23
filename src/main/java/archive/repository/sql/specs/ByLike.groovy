package archive.repository.sql.specs

import archive.repository.sql.QueryWhereSpecification
import archive.repository.sql.SqlClause
import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */
@Canonical
class ByLike implements QueryWhereSpecification{
    final String name
    final Object value

    @Override
    SqlClause toSqlClause() {
        return new SqlClause(
            "${name} like :${name}Like", [("${name}Like".toString()) :  value]
        )
    }
}
