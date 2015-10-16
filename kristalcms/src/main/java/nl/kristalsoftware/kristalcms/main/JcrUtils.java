package nl.kristalsoftware.kristalcms.main;

import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 14-10-15.
 */
public interface JcrUtils {

    boolean pathExists(String path) throws RepositoryException;

}
