package nl.kristalsoftware.kristalcms.template.rest;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.template.TemplateController;
import nl.kristalsoftware.kristalcms.templates.rest.TemplatesRSDto;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import org.jboss.resteasy.links.LinkResources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 29-09-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class TemplateResource extends BaseResource<TemplateRSDto> {

    @Inject
    private Logger logger;

    @Inject
    private TemplateController templateController;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = TemplatesRSDto.class, rel = "template")
    })
    @GET
    @Produces("text/html")
    @Path("{customerId}/templates/{templateId}")
    public String getTemplate(@PathParam("customerId") String customerId, @PathParam("templateId") String templateId, @Context UriInfo uriInfo) {
        TemplateRSDto templateRSDto = super.getResourceType(uriInfo.getPath());
        templateRSDto.setCustomerId(customerId);
        return templateRSDto.getTemplateContent();
    }

    /*
    @LinkResource(value = TemplatesRSDto.class)
    @POST
    @Path("{customerId}/templates")
    public Response createTemplate(@PathParam("customerId") String customerId, TemplateRSDto templateRSDto, @Context UriInfo uriInfo) {
        templateUriInfo.setCustomerId(customerId);
        templateUriInfo.setUriInfo(uriInfo);
        return super.createResourceType(templateRSDto);
    }

    @DELETE
    @Path("{customerId}/templates/{templateId}")
    public Response removeTemplate(String customerId, String templateId, @Context UriInfo uriInfo) {
        templateUriInfo.setUriInfo(uriInfo);
        return super.removeResourceType();
    }
    */

    @Override
    protected BaseController<TemplateRSDto> getController() {
        return templateController;
    }

}
