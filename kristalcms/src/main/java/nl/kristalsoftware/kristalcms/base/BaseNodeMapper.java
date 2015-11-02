package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public abstract class BaseNodeMapper<T extends BaseEntity> {

    public T getEntity(String path) throws PathNotFoundException, RepositoryException {
        getJcrData().setNode(path);
        getBaseEntity().setPath(path);
        return getEntity();
    }

    protected abstract T getEntity() throws RepositoryException;

    public abstract BaseJcrData getJcrData();

    public abstract BaseEntity getBaseEntity();

}
