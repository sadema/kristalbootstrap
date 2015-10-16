package nl.kristalsoftware.kristalcms.main;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by sjoerdadema on 14-10-15.
 */
public class JcrUtilsImpl implements JcrUtils {

    @Inject
    private Session session;

    @Override
    public boolean pathExists(String path) throws RepositoryException {
        return session.nodeExists(path);
    }
}
