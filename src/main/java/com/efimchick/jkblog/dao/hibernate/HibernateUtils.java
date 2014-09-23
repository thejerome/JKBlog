package com.efimchick.jkblog.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Jerome on 16.07.2014.
 */
public class HibernateUtils {

    public static void applyPaging(int pageNumber, int perPage, Query query) {
        if (pageNumber > 0 && perPage > 0) {
            query.setFirstResult((pageNumber - 1) * perPage);
            query.setMaxResults(perPage);
        }
    }


    public static void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }
}
