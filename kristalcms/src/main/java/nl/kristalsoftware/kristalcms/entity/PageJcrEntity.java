package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.data.PageData;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageJcrEntity extends BaseJcrEntity implements IBaseJcrEntity<PageData> {

    @Inject
    private Session session;

    @Inject
    private PageData pageData;

    @Inject
    @TextFile
    private JcrProperty<String> content;

    @Override
    public PageData getData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        this.setDataFromJcrValues(node);
        return pageData;
    }

    @Override
    public String setData(String parentPath, PageData data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        if (!nodeExists(session, buildPath(parentPath, data.getNodename()))) {
            Node pageNode = node.addNode(data.getNodename(), "nt:file");
            newPath = pageNode.getPath();
            this.setJcrValuesFromData(pageNode, data);
            session.save();
        }
        else {
            throw new ItemExistsException("Node " + data.getNodename() + " already exists");
        }
        return newPath;
    }

    @Override
    public void setDataFromJcrValues(Node node) throws PathNotFoundException, RepositoryException  {
        pageData.setNodename(node.getName());
        pageData.setPageContent(content.getPropertyValue(node, "content"));
    }

    @Override
    public void setJcrValuesFromData(Node node, PageData data) throws PathNotFoundException, RepositoryException {
        content.setPropertyValue(node, "content", data.getPageContent());
    }
}
