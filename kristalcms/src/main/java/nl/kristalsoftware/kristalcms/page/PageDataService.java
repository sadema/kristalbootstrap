package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.freemarker.PageEventData;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageDataService extends BaseDataService<PageRSDto,PageUriInfo> {

    public final static String HTMLNODENAME = "html";
    public final static String CONTENTNODENAME = "content";

    @Inject
    private BaseMapper<PageRSDto,PageUriInfo> pageMapper;

    @Override
    public BaseMapper<PageRSDto, PageUriInfo> getMapper() {
        return pageMapper;
    }

    @Inject
    private Event<PageEventData> createHtmlPageEvent;

    @Override
    public String createData(PageUriInfo uriInfo, PageRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        createHtmlPageEvent.fire(new PageEventData(uriInfo, data));
        return super.createData(uriInfo, data);
    }

    @Override
    public Node createNode(Node parentNode, String nodeName) throws ItemExistsException, RepositoryException {
        Node newPageNode = super.createNode(parentNode, nodeName);
        Node htmlNode = newPageNode.addNode(HTMLNODENAME);
        htmlNode.addNode(CONTENTNODENAME, "nt:file");
        return newPageNode;
    }
}
