package nl.kristalsoftware.kristalcms.customer;

import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 08-09-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public interface ICustomerResource {

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}")
    CustomerRSDto getCustomer(@PathParam("customerId") String customerId, @Context UriInfo uriInfo);

}
