package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.dto.CreatePageRSDto;
import nl.kristalsoftware.kristalcms.dto.CustomerRSDto;
import nl.kristalsoftware.kristalcms.dto.PageRSDto;
import nl.kristalsoftware.kristalcms.dto.PagesRSDto;
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
            @LinkResource(value = CustomerRSDto.class, rel = "list")
    })
    @GET
    @Path("{customerId}/pages")
    PagesRSDto getPages(@PathParam("customerId") String customerId, @Context UriInfo uriInfo);

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}/pages/{pageId}")
    PageRSDto getPage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo);

    @LinkResource(value = PagesRSDto.class)
    @POST
    @Path("{customerId}/pages")
    Response createPage(@PathParam("customerId") String customerId, CreatePageRSDto createPageRSDto, @Context UriInfo uriInfo);

    @DELETE
    @Path("{customerId}/pages/{pageId}")
    Response removePage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo);
}
