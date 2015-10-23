package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class TemplateService extends BaseDataService<TemplateRSDto,TemplateUriInfo> { // implements DataService<TemplateRSDto> {

    public final static String HTMLNODENAME = "html";
    public final static String CONTENTNODENAME = "content";

    @Inject
    private BaseMapper<TemplateRSDto,TemplateUriInfo> templateMapper;

    @Override
    public BaseMapper<TemplateRSDto,TemplateUriInfo> getMapper() {
        return templateMapper;
    }

    @Override
    public Node createNode(Node parentNode, String nodeName) throws ItemExistsException, RepositoryException {
        Node newTemplateNode = super.createNode(parentNode, nodeName);
        Node htmlNode = newTemplateNode.addNode(HTMLNODENAME);
        htmlNode.addNode(CONTENTNODENAME, "nt:file");
        return newTemplateNode;
    }

    /*
    @Inject
    @TextFile
    private JcrProperty<String> content;

    @Override
    public String createData(String parentPath, TemplateRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        if (!nodeExists(session, buildPath(parentPath, data.getTemplateId()))) {
            Node templateNode = node.addNode(data.getTemplateId(), "nt:file");
            newPath = templateNode.getPath();
            templateJcrData.setContent(templateNode, data.getTemplateContent());
            session.save();
        }
        else {
            throw new ItemExistsException("Node " + data.getTemplateId() + " already exists");
        }
        return newPath;
    }

*/
}
