package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.base.DataService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerService extends BaseDataService<CustomerRSDto,CustomerUriInfo> implements DataService<CustomerRSDto,CustomerUriInfo> {

    @Inject
    private BaseMapper<CustomerRSDto,CustomerUriInfo> customerMapper;

    @Override
    public BaseMapper<CustomerRSDto,CustomerUriInfo> getMapper() {
        return customerMapper;
    }
}
