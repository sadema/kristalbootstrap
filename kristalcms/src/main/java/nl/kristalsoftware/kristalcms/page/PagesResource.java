package nl.kristalsoftware.kristalcms.page;

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
 * Created by sjoerdadema on 20-10-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class PagesResource extends BaseResource<PagesRSDto,PagesUriInfo> {

    @Inject
    private BaseDataService<PagesRSDto,PagesUriInfo> pagesService;

    @Inject
    private PagesUriInfo pagesUriInfo;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = CustomerRSDto.class, rel = "list")
    })
    @GET
    @Path("{customerId}/pages")
    PagesRSDto getPages(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        setPagesUriInfo(customerId, uriInfo);
        return getResourceType();
    }

    private void setPagesUriInfo(String customerId, UriInfo uriInfo) {
        pagesUriInfo.setCustomerId(customerId);
        pagesUriInfo.setUriInfo(uriInfo);
    }

    @Override
    protected BaseDataService<PagesRSDto, PagesUriInfo> getResourceTypeService() {
        return pagesService;
    }

    @Override
    protected PagesUriInfo getResourceUriInfo() {
        return pagesUriInfo;
    }
}