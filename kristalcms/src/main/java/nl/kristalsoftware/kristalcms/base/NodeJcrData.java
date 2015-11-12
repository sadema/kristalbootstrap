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

    //@Inject
    //protected Session session;

    protected NodeJcrData() {}

    /*
    public void setNode(String path) throws PathNotFoundException, RepositoryException {
        node = session.getNode(path);
    }
    */
    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public String getId() throws RepositoryException {
        String id = null;
        if (node != null) {
            id = node.getName();
        }
        else {
            throw new RepositoryException("node is null");
        }
        return id;
    }

}
