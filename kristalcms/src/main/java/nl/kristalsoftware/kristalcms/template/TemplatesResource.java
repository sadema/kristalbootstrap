package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.Templates;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;
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

/**
 * Created by sjoerdadema on 23/10/15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class TemplatesResource extends BaseResource<TemplatesRSDto,TemplatesUriInfo> {

    @Inject
    private TemplatesUriInfo templatesUriInfo;

    @Inject
    //@Templates
    private BaseDataService<TemplatesRSDto,TemplatesUriInfo> templatesService;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerRSDto.class, rel = "templates")
    })
    @GET
    @Path("{customerId}/templates")
    TemplatesRSDto getTemplates(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        templatesUriInfo.setCustomerId(customerId);
        templatesUriInfo.setUriInfo(uriInfo);
        return super.getResourceType();
    }

    @Override
    protected BaseDataService<TemplatesRSDto, TemplatesUriInfo> getResourceTypeService() {
        return templatesService;
    }

    @Override
    protected TemplatesUriInfo getResourceUriInfo() {
        return templatesUriInfo;
    }
}
