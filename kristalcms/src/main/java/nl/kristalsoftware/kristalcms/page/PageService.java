package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.*;
import nl.kristalsoftware.kristalcms.freemarker.PageEventData;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageService extends BaseDataService<PageRSDto,Page> implements DataService<PageRSDto,Page> {

    public final static String HTMLNODENAME = "html";
    public final static String CONTENTNODENAME = "content";

    @Inject
    private Event<PageEventData> createHtmlPageEvent;

    @Override
    public BaseDAO<Page> getDAO() {
        return null;
    }

    @Override
    protected PageRSDto setEntity(Page entity) {
        return null;
    }

    /*
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
    */

}
