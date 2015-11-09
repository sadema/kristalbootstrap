package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.JcrUtils;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class NodeJcrData {

    protected Node node = null;

    @Inject
    private Session session;

    protected NodeJcrData() {}

    public void setNode(String path) throws PathNotFoundException, RepositoryException {
        node = session.getNode(path);
    }

    public Node getNode() {
        return node;
    }

    public String getId() throws RepositoryException {
        return node.getName();
    }

}
