package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.property.JcrContentNode;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 20-09-15.
 */
public class PageJcrData {

    @Inject
    @TextFile
    private JcrContentNode<String> content;

    public String getPageId(Node node) throws RepositoryException {
        return node.getName();
    }

    public String getContent(Node node) throws RepositoryException {
        return content.getValue(node);
    }

    public void setContent(Node node, String value) throws RepositoryException {
        content.setValue(node, value);
    }
}
