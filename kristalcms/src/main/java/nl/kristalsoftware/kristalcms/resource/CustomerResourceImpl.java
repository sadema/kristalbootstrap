package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.data.CustomerData;
import nl.kristalsoftware.kristalcms.entity.BaseJcrEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    private BaseJcrEntity<CustomerData> customerJcr;

    public CustomerData getCustomer(String customerId, @Context UriInfo uriInfo) {
        logger.info(uriInfo.getPath());
        return customerJcr.getData(uriInfo.getPath());
    }
}
