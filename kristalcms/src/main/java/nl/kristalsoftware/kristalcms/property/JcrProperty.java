package nl.kristalsoftware.kristalcms.property;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface JcrProperty<T> {
    T getPropertyValue(Node node, String propertyName) throws RepositoryException;
    void setPropertyValue(Node node, String propertyName, T pageContent) throws RepositoryException;
}
