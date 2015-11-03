package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.corejcr.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 20-09-15.
 */
public class TemplateJcrData {

    @Inject
    @TextFile
    private JcrProperty<String> content;

    public String getTemplateId(Node node) throws RepositoryException {
        return node.getName();
    }

    public String getContent(Node node) throws RepositoryException {
        return content.getPropertyValue(node, "content");
    }

    public void setContent(Node node, String value) throws RepositoryException {
        content.setPropertyValue(node, "content", value);
    }
}
