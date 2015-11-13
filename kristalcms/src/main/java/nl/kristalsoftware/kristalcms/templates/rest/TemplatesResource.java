package nl.kristalsoftware.kristalcms.templates.rest;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;
import nl.kristalsoftware.kristalcms.template.rest.TemplateRSDto;
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
import java.util.List;

/**
 * Created by sjoerdadema on 23/10/15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class TemplatesResource extends BaseResource<TemplatesRSDto> {

    @Inject
    private BaseController<TemplatesRSDto> templatesController;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerRSDto.class, rel = "templates")
    })
    @GET
    @Path("{customerId}/templates")
    public TemplatesRSDto getTemplates(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        TemplatesRSDto templatesRSDto = super.getResourceType(uriInfo.getPath());
        templatesRSDto.setCustomer(customerId);
        List<TemplateRSDto> templateList = templatesRSDto.getTemplateList();
        for (TemplateRSDto templateRSDto : templateList) {
            templateRSDto.setCustomerId(customerId);
        }
        return templatesRSDto;
    }

    @Override
    protected BaseController<TemplatesRSDto> getController() {
        return templatesController;
    }
}
