package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.Customer;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@Path("/customers")
@Produces("application/xml")
public class CustomerResourceImpl {

    @Inject
    private Logger logger;

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}")
    public Customer getCustomer(@PathParam("customerId") String customerId, @Context UriInfo uriInfo) {
        logger.info(uriInfo.getPath());
        return new Customer(customerId);
    }
}
