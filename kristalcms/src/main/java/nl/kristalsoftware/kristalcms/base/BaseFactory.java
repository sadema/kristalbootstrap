package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public interface BaseFactory<T> {

    T createEntity(String path) throws PathNotFoundException, RepositoryException;
    List<String> createEntityPathList(String parentPath) throws RepositoryException;
}
