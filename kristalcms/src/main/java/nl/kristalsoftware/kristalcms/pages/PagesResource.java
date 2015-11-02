package nl.kristalsoftware.kristalcms.pages;

import nl.kristalsoftware.kristalcms.base.BaseController;
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
 * Created by sjoerdadema on 20-10-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class PagesResource extends BaseResource<PagesRSDto> {

    @Inject
    private PagesController pagesController;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerRSDto.class, rel = "list")
    })
    @GET
    @Path("{customerId}/pages")
    PagesRSDto getPages(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        return super.getResourceType(uriInfo.getPath());
    }

    @Override
    protected BaseController<PagesRSDto> getController() {
        return null;
    }
}
