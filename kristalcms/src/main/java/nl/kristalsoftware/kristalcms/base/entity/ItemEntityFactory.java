package nl.kristalsoftware.kristalcms.base.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public abstract class ItemEntityFactory<T extends BaseEntity> extends RootItemEntityFactory<T> implements BaseItemEntityFactory {

    protected ItemEntityFactory(Session session) {
        super(session);
    }

    public List<String> createEntityPathList(String parentPath) throws RepositoryException {
        List<String> entityPathList = new ArrayList<String>();
        List<Node> nodeList = getJcrNodeList(session, parentPath);
        for (Node node : nodeList) {
            entityPathList.add(node.getPath());
        }
        return entityPathList;
    }

    protected abstract List<Node> getJcrNodeList(Session session, String parentPath) throws RepositoryException;

}
