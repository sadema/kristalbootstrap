package nl.kristalsoftware.kristalcms.base;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public abstract class BaseDataService<T,U extends BaseUriInfo> {

    @Inject
    protected Session session;

    @Inject
    protected DataServiceUtils dataServiceUtils;

    protected BaseDataService() {}

    public T getData(U uriInfo) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(uriInfo.getPath());
        return getMapper().setFieldsInDto(node, uriInfo);
    }

    public String createData(U uriInfo, T data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(uriInfo.getPath());
        Node newNode = createNode(node, uriInfo.getNodename());
        getMapper().setFieldsInRepository(node, data);
        return newNode.getPath();
    }

    public void removeData(U uriInfo) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(uriInfo.getPath());
        removeNode(node);
        session.save();
    }

    public Node createNode(Node parentNode, String nodeName) throws ItemExistsException, RepositoryException {
        Node newNode = null;
        if (this.nodeExists(parentNode, nodeName)) {
            newNode = parentNode.addNode(nodeName);
        }
        else {
            throw new ItemExistsException();
        }
        return newNode;
    }

    public void removeNode(Node node) throws RepositoryException {
        node.remove();
    }

    protected boolean nodeExists(Node parentNode, String nodeName) throws RepositoryException {
        return dataServiceUtils.nodeExists(session, dataServiceUtils.buildPath(parentNode.getPath(), nodeName));
    }

    public abstract BaseMapper<T,U> getMapper();

}
