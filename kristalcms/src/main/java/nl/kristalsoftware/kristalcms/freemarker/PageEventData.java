package nl.kristalsoftware.kristalcms.freemarker;

import nl.kristalsoftware.kristalcms.page.PageRSDto;
import nl.kristalsoftware.kristalcms.page.PageUriInfo;

import javax.enterprise.event.Event;

/**
 * Created by sjoerdadema on 26/10/15.
 */
public class PageEventData {

    private PageUriInfo pageUriInfo;
    private PageRSDto pageRSDto;

    public PageEventData(PageUriInfo uriInfo, PageRSDto data) {
        this.pageUriInfo = pageUriInfo;
        this.pageRSDto = pageRSDto;
    }


}
