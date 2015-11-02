package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public abstract class BaseDAO<T extends BaseEntity> {

    protected BaseDAO() {}

    public T getEntity(String path) throws PathNotFoundException, CMSDataException{
        T entity = null;
        try {
            entity = getMapper().getEntity(path);
        } catch (RepositoryException e) {
            throw new CMSDataException(e);
        }
        return entity;
    }

    protected abstract BaseMapper<T> getMapper();
}
