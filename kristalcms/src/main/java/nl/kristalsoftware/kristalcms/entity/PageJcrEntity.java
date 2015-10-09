package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.jcrdata.PageJcrData;
import nl.kristalsoftware.kristalcms.dto.PageRSDto;
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
    private PageJcrData pageJcrData;

//    @Inject
//    @TextFile
//    private JcrProperty<String> content;

    @Override
    public PageRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        PageRSDto pageRSDto = new PageRSDto();
        Node node = session.getNode(path);
        pageRSDto.setPageId(pageJcrData.getPageId(node));
        pageRSDto.setPageContent(pageJcrData.getContent(node));
        return pageRSDto;
    }

    @Override
    public String createData(String parentPath, PageRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        if (!nodeExists(session, buildPath(parentPath, data.getPageId()))) {
            Node pageNode = node.addNode(data.getPageId(), "nt:file");
            newPath = pageNode.getPath();
            pageJcrData.setContent(pageNode, data.getPageContent());
            session.save();
        }
        else {
            throw new ItemExistsException("Node " + data.getPageId() + " already exists");
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
