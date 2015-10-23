package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.DataServiceUtils;
import nl.kristalsoftware.kristalcms.base.DataService;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageDataService extends DataServiceUtils implements DataService<PageRSDto,PageUriInfo> {

    @Inject
    private Session session;

    @Inject
    private PageJcrData pageJcrData;

//    @Inject
//    @TextFile
//    private JcrProperty<String> content;

    @Deprecated
    public PageRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        PageRSDto pageRSDto = new PageRSDto();
        Node node = session.getNode(path);
        pageRSDto.setPageId(pageJcrData.getPageId(node));
        pageRSDto.setPageContent(pageJcrData.getContent(node));
        return pageRSDto;
    }

    @Override
    public PageRSDto getData(PageUriInfo baseUriInfo) throws PathNotFoundException, RepositoryException {
        return null;
    }

    @Override
    public String createData(String parentPath, PageRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        if (!nodeExists(session, buildPath(parentPath, data.getPageId()))) {
            Node pageNode = node.addNode(data.getPageId());
            newPath = pageNode.getPath();
            Node htmlNode = pageNode.addNode("html", "nt:file");
            pageNode.addNode("content");
            pageJcrData.setContent(htmlNode, data.getPageContent());
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
