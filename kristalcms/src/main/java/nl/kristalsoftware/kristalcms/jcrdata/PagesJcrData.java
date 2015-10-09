package nl.kristalsoftware.kristalcms.jcrdata;

import nl.kristalsoftware.kristalcms.dto.PageRSDto;

import javax.inject.Inject;
import javax.jcr.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 09-10-15.
 */
public class PagesJcrData {

    @Inject
    private Session session;

    public List<PageRSDto> getPageList(String path) throws PathNotFoundException, RepositoryException {
        List<PageRSDto> pageList = new ArrayList<PageRSDto>();
        Node node = session.getNode(path);
        NodeIterator nodeIterator = node.getNodes();
        while(nodeIterator.hasNext()) {
            pageList.add(new PageRSDto(nodeIterator.nextNode().getName()));
        }
        return pageList;
    }
}
