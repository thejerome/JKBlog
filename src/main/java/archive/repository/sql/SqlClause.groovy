package archive.repository.sql

import groovy.transform.Canonical

/**
 * Created by Jerome on 24.04.2014.
 */

@Canonical
class SqlClause<T> {

    final String clause
    final Map<String, T> params

    public SqlClause(String clause, Map<String, T> params) {
        this.clause = clause
        this.params = Collections.unmodifiableMap(params)
    }

    final static SqlClause empty = new SqlClause("", [:])
}
