package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class TemplateService extends BaseDataService<TemplateRSDto,TemplateEntity> implements DataService<TemplateRSDto,TemplateEntity> {

    public final static String HTMLNODENAME = "html";
    public final static String CONTENTNODENAME = "content";

    @Override
    protected TemplateRSDto setEntity(TemplateEntity entity) {
        return null;
    }

    @Override
    public <E extends BaseEntity> BaseDAO<E> getDAO() {
        return null;
    }

    /*
    @Override
    public Node createNode(Node parentNode, String nodeName) throws ItemExistsException, RepositoryException {
        Node newTemplateNode = super.createNode(parentNode, nodeName);
        Node htmlNode = newTemplateNode.addNode(HTMLNODENAME);
        htmlNode.addNode(CONTENTNODENAME, "nt:file");
        return newTemplateNode;
    }
    */

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
