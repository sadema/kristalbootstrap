package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.CustomerData;
import nl.kristalsoftware.kristalcms.data.PageData;
import nl.kristalsoftware.kristalcms.data.PagesData;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 15-09-15.
 */
public class PageResourceImpl implements IPageResource {

    @Override
    public PagesData getPages(String customerId, @Context UriInfo uriInfo) {
        CustomerData customerData = new CustomerData(customerId);
        return new PagesData(customerData);
    }

    @Override
    public PageData getPage(String customerId, String pageId, @Context UriInfo uriInfo) {
        CustomerData customerData = new CustomerData(customerId);
        PageData data = new PageData(customerData);
        data.setNodename(pageId);
        data.setPageContent("Hello World");
        return data;
    }

}
