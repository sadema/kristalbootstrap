package nl.kristalsoftware.kristalcms.entity;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 17-09-15.
 */
public class BaseJcrEntity {

    @Inject
    private Logger logger;

    protected BaseJcrEntity() {}

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
}
