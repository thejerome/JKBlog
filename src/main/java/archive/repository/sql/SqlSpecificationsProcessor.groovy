package archive.repository.sql

import archive.repository.QuerySpecification
import groovy.transform.Canonical

/**
 * Created by Jerome on 04.05.2014.
 */

@Canonical
class SqlSpecificationsProcessor {

    final List<SqlClause> whereClauses = Collections.emptyList()
    final SqlClause pagingClause = SqlClause.empty
    final SqlClause orderingClause = SqlClause.empty

    SqlSpecificationsProcessor(QuerySpecification... sqlSpecs) {
        whereClauses = sqlSpecs.grep(QueryWhereSpecification).collect {it.toSqlClause()}
        pagingClause = sqlSpecs.grep(QueryPagingSpecification).find()?.toSqlClause() ?: SqlClause.empty
        orderingClause = sqlSpecs.grep(QueryOrderingSpecification).find()?.toSqlClause() ?: SqlClause.empty
    }

    String addToSql(String initialSql){
        if(whereClauses.isEmpty() && pagingClause.equals(SqlClause.empty)){
            return initialSql + " " + orderingClause.clause;
        } else {
            return initialSql + " WHERE " +
                    whereClauses.collect{it.clause}.join(" AND ") +
                    (pagingClause.clause.isEmpty() ?  "" : " AND " + pagingClause.clause) +
                    " " + orderingClause.clause
        }

    }

    Map<String, Object> getParams(){
        Map<String, Object> params = whereClauses.collect{it.params}.inject(new HashMap<String, Object>(), {acc, val -> acc + val})  + pagingClause.params + orderingClause.params
    }

}
