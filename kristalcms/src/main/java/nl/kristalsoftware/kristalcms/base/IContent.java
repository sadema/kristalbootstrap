package nl.kristalsoftware.kristalcms.base;

import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 30-09-15.
 */
public interface IContent {

    String getContent(String path) throws RepositoryException;

}
