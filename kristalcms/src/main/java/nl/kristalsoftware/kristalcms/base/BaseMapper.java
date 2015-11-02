package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public interface BaseMapper<T> {

    public T getEntity(String path) throws PathNotFoundException, RepositoryException;

}
