package nl.kristalsoftware.kristalcms.property;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 03/11/15.
 */
public interface JcrList {

    public List<Node> getList(String parentPath) throws RepositoryException;

}
