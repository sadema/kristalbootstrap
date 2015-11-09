package nl.kristalsoftware.kristalcms.property;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 03/11/15.
 */
public class JcrNodeList implements JcrList {

    public List<Node> getList(String parentPath) throws RepositoryException {
        List<Node> nodeList = new ArrayList<Node>();
        /*
        NodeIterator iter = node.getNodes();
        while (iter.hasNext()) {
            nodeList.add(iter.nextNode());
        }
        */
        return nodeList;
    }
}
