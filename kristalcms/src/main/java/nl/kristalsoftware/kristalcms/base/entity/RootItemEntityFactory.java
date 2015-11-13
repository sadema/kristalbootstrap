package nl.kristalsoftware.kristalcms.base.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public abstract class RootItemEntityFactory<T extends BaseEntity> implements BaseRootItemEntityFactory {

    protected Session session;

    protected RootItemEntityFactory(Session session) {
        this.session = session;
    }

    public T createEntity(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        getJcrData().setNode(node);
        getBaseEntity().setPath(path);
        return createEntity();
    }

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
