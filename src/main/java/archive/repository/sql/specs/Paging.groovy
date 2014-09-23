package archive.repository.sql.specs

import archive.repository.sql.QueryPagingSpecification
import archive.repository.sql.SqlClause
import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */
@Canonical
class Paging implements QueryPagingSpecification{

    final long page
    final long itemsPerPage

    @Override
    SqlClause toSqlClause() {
        return new SqlClause(
            "rownum > :beginPaging and rownum <= :endPaging",
            ["beginPaging": (page - 1)*itemsPerPage,
             "endPaging" : page*itemsPerPage]
        )
    }
}
