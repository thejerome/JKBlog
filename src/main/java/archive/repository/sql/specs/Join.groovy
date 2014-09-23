package archive.repository.sql.specs

import archive.repository.sql.QueryWhereSpecification
import archive.repository.sql.SqlClause

/**
 * Created by Jerome on 16.06.2014.
 */
class Join implements QueryWhereSpecification {

    private String pk;
    private String fk;

    Join(String pk, String fk) {
        this.pk = pk
        this.fk = fk
    }

    @Override
    SqlClause toSqlClause() {
        return new SqlClause("$pk = $fk", [:])
    }
}
