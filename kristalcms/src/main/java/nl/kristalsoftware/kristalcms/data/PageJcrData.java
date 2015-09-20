package nl.kristalsoftware.kristalcms.data;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 20-09-15.
 */
public class PageJcrData {

    @Inject
    @TextFile
    private JcrProperty<String> content;

    public String getPageId(Node node) throws RepositoryException {
        return node.getName();
    }

    public String getContent(Node node) throws RepositoryException {
        return content.getPropertyValue(node, "content");
    }
}
