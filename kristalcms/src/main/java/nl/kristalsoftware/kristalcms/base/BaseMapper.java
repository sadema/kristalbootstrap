package nl.kristalsoftware.kristalcms.base;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public interface BaseMapper<T,U extends BaseUriInfo> {

    public T setFieldsInDto(Node node, U uriInfo) throws PathNotFoundException, RepositoryException;
    public void setFieldsInRepository(Node node, T data) throws PathNotFoundException, ItemExistsException, RepositoryException;

}
