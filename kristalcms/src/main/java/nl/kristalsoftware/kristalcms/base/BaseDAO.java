package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
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
            entity = getFactory().createEntity(path);
        } catch (RepositoryException e) {
            throw new CMSDataException(e);
        }
        return entity;
    }

    protected abstract BaseRootItemEntityFactory<T> getFactory();
}
