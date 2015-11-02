package nl.kristalsoftware.kristalcms.base;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public interface BaseDtoMapper<T,E extends BaseEntity> {

    public T setFieldsInDto(E entity) throws PathNotFoundException, RepositoryException;
    public void setFieldsInRepository(Node node, T data) throws PathNotFoundException, ItemExistsException, RepositoryException;

}
