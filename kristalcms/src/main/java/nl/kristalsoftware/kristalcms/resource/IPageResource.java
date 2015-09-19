package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.CustomerData;
import nl.kristalsoftware.kristalcms.data.PageData;
import nl.kristalsoftware.kristalcms.data.PagesData;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import org.jboss.resteasy.links.LinkResources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 08-09-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public interface IPageResource {

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerData.class, rel = "pages")
    })
    @GET
    @Path("{customerId}/pages")
    PagesData getPages(@PathParam("customerId") String customerId, @Context UriInfo uriInfo);

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}/pages/{pageId}")
    PageData getPage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo);

    @LinkResource(value = PagesData.class)
    @POST
    @Path("{customerId}/pages")
    Response createPage(@PathParam("customerId") String customerId, PageData pageData, @Context UriInfo uriInfo);

    @DELETE
    @Path("{customerId}/pages/{pageId}")
    Response removePage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo);
}
