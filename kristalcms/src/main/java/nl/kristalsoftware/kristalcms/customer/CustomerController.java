package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomerController extends BaseController<CustomerRSDto> {

    @Inject
    private CustomerService customerService;

    @Override
    protected BaseDataService<CustomerRSDto,CustomerEntity> getResourceTypeService() {
        return customerService;
    }
}