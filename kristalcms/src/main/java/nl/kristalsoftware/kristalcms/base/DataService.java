package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface DataService<T,E extends BaseEntity> {

    T getData(String path) throws PathNotFoundException, CMSDataException;
    //String createData(U baseUriInfo, T data) throws PathNotFoundException, ItemExistsException, RepositoryException;
    //void removeData(U baseUriInfo) throws PathNotFoundException, RepositoryException;

}
