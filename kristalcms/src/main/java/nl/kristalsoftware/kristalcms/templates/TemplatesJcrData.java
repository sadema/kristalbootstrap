package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.NodeJcrData;
import nl.kristalsoftware.kristalcms.property.JcrList;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 19-09-15.
 */
public class TemplatesJcrData extends NodeJcrData implements BaseJcrData {

    /*
    @Inject
    private JcrList nodeList;

    public List<Node> getTemplateList() throws RepositoryException {
        return nodeList.getList(node);
    }
    */

}
