package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@RequestScoped
@Path("/cms")
@Produces("application/json,application/xml")
public class CustomerResource extends BaseResource<CustomerRSDto,CustomerUriInfo> {

    @Inject
    private CustomerUriInfo customerUriInfo;

    @Inject
    private DataService<CustomerRSDto,CustomerUriInfo> customerService;

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}")
    CustomerRSDto getCustomer(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        setCustomerUriInfo(customerId, uriInfo);
        return super.getResourceType();
    }

    private void setCustomerUriInfo(String customerId, UriInfo uriInfo) {
        customerUriInfo.setCustomerId(customerId);
        customerUriInfo.setUriInfo(uriInfo);
    }

    @Override
    protected DataService<CustomerRSDto, CustomerUriInfo> getResourceTypeService() {
        return customerService;
    }

    @Override
    protected CustomerUriInfo getResourceUriInfo() {
        return customerUriInfo;
    }
}
