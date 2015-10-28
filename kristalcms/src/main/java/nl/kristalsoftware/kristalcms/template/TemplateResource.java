package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import org.jboss.resteasy.links.LinkResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 29-09-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class TemplateResource extends BaseResource<TemplateRSDto,TemplateUriInfo> {

    @Inject
    private Logger logger;

    @Inject
    private BaseDataService<TemplateRSDto,TemplateUriInfo> templateService;

    @Inject
    private TemplateUriInfo templateUriInfo;

    @GET
    @Produces("text/html")
    @Path("{customerId}/templates/{templateId}")
    public String getTemplate(@PathParam("customerId") String customerId, @PathParam("templateId") String templateId, @Context UriInfo uriInfo) {
        templateUriInfo.setCustomerId(customerId);
        templateUriInfo.setTemplateId(templateId);
        templateUriInfo.setUriInfo(uriInfo);
        return super.getResourceType().getTemplateContent();
    }

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

    @Override
    protected BaseDataService<TemplateRSDto, TemplateUriInfo> getResourceTypeService() {
        return templateService;
    }

    @Override
    protected TemplateUriInfo getResourceUriInfo() {
        return templateUriInfo;
    }
}
