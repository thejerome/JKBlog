package archive.repository.sql

import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */

@Canonical
class CombinedWhereSpecification<T> implements QueryWhereSpecification {

    final String clause
    final Map<String, T> params

    public CombinedWhereSpecification(String joiner, SqlSpecification... specs) {
        this.clause = "(" + specs.collect{it.toSqlClause().clause}.join(" " + joiner + " ") + ")";
        this.params = Collections.unmodifiableMap(specs.collect{it.toSqlClause().params}.inject {acc, val -> acc+ val})
    }

    final static String AND = "AND";
    final static String OR = "OR";

    @Override
    SqlClause toSqlClause() {
        return new SqlClause(clause, params)
    }
}
