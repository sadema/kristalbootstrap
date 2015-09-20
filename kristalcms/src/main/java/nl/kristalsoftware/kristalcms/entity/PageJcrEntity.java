package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.data.PageJcrData;
import nl.kristalsoftware.kristalcms.data.PageRSDto;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageJcrEntity extends BaseJcrEntity implements IBaseJcrEntity<PageRSDto> {

    @Inject
    private Session session;

    @Inject
    private PageRSDto pageRSDto;

    @Inject
    private PageJcrData pageJcrData;

    @Inject
    @TextFile
    private JcrProperty<String> content;

    @Override
    public PageRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        pageRSDto.setPageId(pageJcrData.getPageId(node));
        pageRSDto.setPageContent(pageJcrData.getContent(node));
        return pageRSDto;
    }

    @Override
    public String setData(String parentPath, PageRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
/*
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
*/
        return newPath;
    }

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        node.remove();
        session.save();
    }

/*
    @Override
    public void setDataFromJcrValues(Node node) throws PathNotFoundException, RepositoryException  {
        pageRSDto.setNodename(node.getName());
        pageRSDto.setPageContent(content.getPropertyValue(node, "content"));
    }

    @Override
    public void setJcrValuesFromData(Node node, PageRSDto data) throws PathNotFoundException, RepositoryException {
        content.setPropertyValue(node, "content", data.getPageContent());
    }
*/
}
