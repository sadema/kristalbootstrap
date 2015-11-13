package nl.kristalsoftware.kristalcms.base.entity;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public interface BaseRootItemEntityFactory<T> {

    T createEntity(String path) throws PathNotFoundException, RepositoryException;
}
