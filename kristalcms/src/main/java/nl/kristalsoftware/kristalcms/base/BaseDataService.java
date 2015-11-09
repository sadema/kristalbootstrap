package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public abstract class BaseDataService<T,E extends BaseEntity> {

    //@Inject
    //protected DataServiceUtils dataServiceUtils;

    protected BaseDataService() {}

    public T getData(String path) throws PathNotFoundException, CMSDataException {
        BaseDAO<E> baseDAO = getDAO();
        E entity = baseDAO.getEntity(path);
        T rsDto = setEntity(entity);
        return rsDto;
    }

    protected abstract T setEntity(E entity);

    /*
    public String createData(U uriInfo, T data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(uriInfo.getPath());
        Node newNode = createNode(node, uriInfo.getNodename());
        getFactory().setFieldsInRepository(node, data);
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

    public abstract BaseDtoMapper<T,E> getFactory();
    */

    public abstract <E extends BaseEntity> BaseDAO<E> getDAO();
}
