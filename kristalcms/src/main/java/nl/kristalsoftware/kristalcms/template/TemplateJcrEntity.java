package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class TemplateJcrEntity extends BaseDataService implements DataService<TemplateRSDto> {

    @Inject
    private Session session;

    @Inject
    private TemplateJcrData templateJcrData;

    @Inject
    @TextFile
    private JcrProperty<String> content;

    @Override
    public TemplateRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        TemplateRSDto templateRSDto = new TemplateRSDto();
        Node node = session.getNode(path);
        templateRSDto.setTemplateId(templateJcrData.getTemplateId(node));
        templateRSDto.setTemplateContent(templateJcrData.getContent(node));
        return templateRSDto;
    }

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

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        node.remove();
        session.save();
    }

}
