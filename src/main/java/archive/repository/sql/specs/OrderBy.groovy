package archive.repository.sql.specs

import archive.repository.sql.QueryOrderingSpecification
import archive.repository.sql.SqlClause
import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */
@Canonical
class OrderBy implements QueryOrderingSpecification{

    final String field

    @Override
    SqlClause toSqlClause() {
        return new SqlClause(
            "order by $field", [:]
        )
    }
}
