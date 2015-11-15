package nl.kristalsoftware.kristalcms.customers.rest;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;
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
public class CustomersResource extends BaseResource<CustomersRSDto> {

    @Inject
    private BaseController<CustomersRSDto> customersController;

    @AddLinks
    @GET
    public CustomersRSDto getCustomers(@Context UriInfo uriInfo) {
        CustomersRSDto customersRSDto = super.getResourceType(uriInfo.getPath());
//        CustomersRSDto customersRSDto = new CustomersRSDto();
        return customersRSDto;
    }

    @Override
    protected BaseController<CustomersRSDto> getController() {
        return customersController;
    }

}
