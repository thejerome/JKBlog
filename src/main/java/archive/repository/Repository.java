package archive.repository;

import java.util.List;

/**
 * Created by Jerome on 24.04.2014.
 */
public interface Repository <T> {
    void add(T element) throws RepositoryException;
    void remove (T element) throws RepositoryException;
    void update (T element) throws RepositoryException;

    List<T> query(QuerySpecification... specifications);

}
