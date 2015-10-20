package nl.kristalsoftware.kristalcms.content.resource;

import nl.kristalsoftware.kristalcms.content.ContentRSDto;
import nl.kristalsoftware.kristalcms.page.PageRSDto;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import org.jboss.resteasy.links.LinkResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 18-10-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public interface ContentResourceDefinition {

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = PageRSDto.class, rel = "content")
    })
    @GET
    @Path("{customerId}/pages/{pageId}/content")
    public ContentRSDto getContent(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo);
}
