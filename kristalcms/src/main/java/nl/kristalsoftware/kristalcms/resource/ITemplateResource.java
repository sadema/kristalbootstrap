package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.dto.CustomerRSDto;
import nl.kristalsoftware.kristalcms.dto.PageRSDto;
import nl.kristalsoftware.kristalcms.dto.PagesRSDto;
import nl.kristalsoftware.kristalcms.dto.TemplateRSDto;
import nl.kristalsoftware.kristalcms.dto.TemplatesRSDto;
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
public interface ITemplateResource {

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerRSDto.class, rel = "templates")
    })
    @GET
    @Path("{customerId}/templates")
    TemplatesRSDto getTemplates(@PathParam("customerId") String customerId, @Context UriInfo uriInfo);

    @GET
    @Produces("text/html")
    @Path("{customerId}/templates/{templateId}")
    String getTemplate(@PathParam("customerId") String customerId, @PathParam("templateId") String templateId, @Context UriInfo uriInfo);

    @LinkResource(value = TemplatesRSDto.class)
    @POST
    @Path("{customerId}/templates")
    Response createTemplate(@PathParam("customerId") String customerId, TemplateRSDto templateRSDto, @Context UriInfo uriInfo);

    @DELETE
    @Path("{customerId}/templates/{templateId}")
    Response removeTemplate(@PathParam("customerId") String customerId, @PathParam("templateId") String templateId, @Context UriInfo uriInfo);
}
