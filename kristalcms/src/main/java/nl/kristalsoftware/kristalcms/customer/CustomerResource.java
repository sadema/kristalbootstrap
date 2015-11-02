package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@RequestScoped
@Path("/cms")
@Produces("application/json,application/xml")
@Consumes("application/json,application/xml")
public class CustomerResource extends BaseResource<CustomerRSDto> {

    @Inject
    private BaseController<CustomerRSDto> customerController;

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}")
    public CustomerRSDto getCustomer(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        CustomerRSDto customerRSDto = super.getResourceType(uriInfo.getPath());
        return customerRSDto;
    }

    @Override
    protected BaseController<CustomerRSDto> getController() {
        return customerController;
    }
}
