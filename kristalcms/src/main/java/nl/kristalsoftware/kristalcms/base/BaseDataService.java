package nl.kristalsoftware.kristalcms.base;

import javax.inject.Inject;
import javax.jcr.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 17-09-15.
 */
public class BaseDataService {

    @Inject
    private Logger logger;

    protected BaseDataService() {}

    protected Node getNode(Session session, String path) throws RepositoryException {
        Node node = null;
        try {
            node = session.getNode(path);
        } catch (PathNotFoundException e) {
            logger.info("Node on path " + path + " not found");
        }
        return node;
    }

    protected String buildPath(String parentPath, String id) {
        StringBuilder pathBuilder = new StringBuilder(parentPath).append('/').append(id);
        return pathBuilder.toString();
    }

    protected boolean nodeExists(Session session, String path) {
        boolean nodeExists = false;
        try {
            nodeExists = session.nodeExists(path);
        } catch (RepositoryException e) {
            logger.info(path + " already exists");
        }
        return nodeExists;

    }

    protected void assertNodeExists(Session session, String path) throws PathNotFoundException {
        try {
            session.nodeExists(path);
        } catch (RepositoryException e) {
            logger.info(path + " does not exists");
            throw new PathNotFoundException(e);
        }
    }
}
