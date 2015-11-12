package nl.kristalsoftware.kristalcms.base;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public interface BaseJcrData {

    void setNode(Node node) throws RepositoryException;
    Node getNode();

}
