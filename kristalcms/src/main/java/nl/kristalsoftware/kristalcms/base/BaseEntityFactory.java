package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.property.JcrList;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public abstract class BaseEntityFactory<T extends BaseEntity> {

    private Session session;

    @Inject
    private JcrList jcrList;

    protected BaseEntityFactory(Session session) {
        this.session = session;
    }

    public T createEntity(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        getJcrData().setNode(node);
        getBaseEntity().setPath(path);
        return createEntity();
    }

    public List<String> createEntityPathList(String parentPath) throws RepositoryException {
        List<String> entityPathList = new ArrayList<String>();
        List<Node> nodeList = jcrList.getList(parentPath);
        for (Node node : nodeList) {
            entityPathList.add(node.getPath());
        }
        return entityPathList;
    }

    /*
    public List<T> getEntityList(Node parentNode) throws RepositoryException {
        List<T> entityList = new ArrayList<T>();
        List<Node> nodeList = jcrList.getList(parentNode);
        for (Node node : nodeList) {
            entityList.add(this.createEntity(node.getPath()));
        }
        return entityList;
    }
    */

    protected Node getNode() {
        return getJcrData().getNode();
    }

    protected String getPath() {
        return getBaseEntity().getPath();
    }

    protected abstract T createEntity() throws RepositoryException;

    protected abstract BaseJcrData getJcrData();

    protected abstract BaseEntity getBaseEntity();

}
