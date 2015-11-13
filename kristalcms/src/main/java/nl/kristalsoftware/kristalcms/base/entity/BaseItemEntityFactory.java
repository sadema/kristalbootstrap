package nl.kristalsoftware.kristalcms.base.entity;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public interface BaseItemEntityFactory<T> extends BaseRootItemEntityFactory<T> {

    List<String> createEntityPathList(String parentPath) throws RepositoryException;

}
