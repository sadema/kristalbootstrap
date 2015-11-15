package nl.kristalsoftware.kristalcms.customers;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.customers.entity.CustomersEntity;
import nl.kristalsoftware.kristalcms.customers.rest.CustomersRSDto;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class CustomersController extends BaseController<CustomersRSDto> {

    @Inject
    private CustomersService customersService;

    @Override
    protected BaseDataService<CustomersRSDto, CustomersEntity> getResourceTypeService() {
        return customersService;
    }
}
