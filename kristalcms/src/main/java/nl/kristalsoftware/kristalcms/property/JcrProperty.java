package nl.kristalsoftware.kristalcms.property;

import javax.jcr.Node;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface JcrProperty<T> {
    T getData(Node node, String propertyName);
}
