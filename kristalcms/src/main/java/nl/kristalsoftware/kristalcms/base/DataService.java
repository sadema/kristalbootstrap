package nl.kristalsoftware.kristalcms.base;

import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface DataService<T,U extends BaseUriInfo> {

    T getData(U baseUriInfo) throws PathNotFoundException, RepositoryException;
    String createData(U baseUriInfo, T data) throws PathNotFoundException, ItemExistsException, RepositoryException;
    void removeData(U baseUriInfo) throws PathNotFoundException, RepositoryException;

}
