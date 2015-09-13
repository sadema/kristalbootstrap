package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.CustomerData;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@RequestScoped
public class CustomerResourceImpl implements ICustomerResource {

    @Inject
    private Logger logger;

    @Inject
    private Session session;

    public CustomerData getCustomer(String customerId, @Context UriInfo uriInfo) {
        logger.info(uriInfo.getPath());
        try {
            Node node = session.getNode(uriInfo.getPath());
        } catch (RepositoryException e) {
        }
        System.out.println(uriInfo.getPath());
        return new CustomerData(customerId);
    }
}
