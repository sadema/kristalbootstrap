package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.CustomerData;
import nl.kristalsoftware.kristalcms.data.PageData;
import nl.kristalsoftware.kristalcms.data.PagesData;
import nl.kristalsoftware.kristalcms.entity.IBaseJcrEntity;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by sjoerdadema on 15-09-15.
 */
public class PageResourceImpl implements IPageResource {

    @Inject
    private IBaseJcrEntity<PageData> pageJcr;

    @Override
    public PagesData getPages(String customerId, @Context UriInfo uriInfo) {
        CustomerData customerData = new CustomerData(customerId);
        return new PagesData(customerData);
    }

    @Override
    public PageData getPage(String customerId, String pageId, @Context UriInfo uriInfo) {
        PageData pageData = null;
        try {
            pageData = pageJcr.getData(uriInfo.getPath());
            pageData.setCustomer(new CustomerData(customerId));
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return pageData;
    }

    @Override
    public Response createPage(String customerId, PageData pageData, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            String newPath = pageJcr.setData(uriInfo.getPath(), pageData);
            if (newPath != null) {
                response = Response.created(URI.create(newPath)).build();
            }
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (ItemExistsException e) {
            throw new WebApplicationException(422);     // unprocessable entity
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
