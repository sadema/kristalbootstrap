package nl.kristalsoftware.kristalcms.template.jcr;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.NodeJcrData;
import nl.kristalsoftware.kristalcms.property.JcrContentNode;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 20-09-15.
 */
public class TemplateJcrData extends NodeJcrData implements BaseJcrData {

    @Inject
    @TextFile
    protected JcrContentNode<String> content;

    public String getContent() throws RepositoryException {
        return content.getValue(node);
    }

    public void setContent(String value) throws RepositoryException {
        content.setValue(node, value);
    }
}
