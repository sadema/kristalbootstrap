package nl.kristalsoftware.kristalcms.customer.resource;

import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;
import nl.kristalsoftware.kristalcms.customer.resource.CustomerResourceDefinition;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@RequestScoped
public class CustomerResource implements CustomerResourceDefinition {

    @Inject
    private Logger logger;

    @Inject
    private DataService<CustomerRSDto> customerJcr;

    public CustomerRSDto getCustomer(String customerId, @Context UriInfo uriInfo) {
        logger.info(uriInfo.getPath());
        CustomerRSDto customerRSDto = null;
        try {
            customerRSDto = customerJcr.getData(uriInfo.getPath());
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return customerRSDto;
    }
}
