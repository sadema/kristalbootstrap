package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseDtoMapper;
import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.customer.CustomerDAO;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerService extends BaseDataService<CustomerRSDto,CustomerEntity> implements DataService<CustomerRSDto,CustomerEntity> {

    @Inject
    private CustomerDAO customerDAO;

    @Override
    public BaseDAO<CustomerEntity> getDAO() {
        return customerDAO;
    }

    protected CustomerRSDto setEntity(CustomerEntity customerEntity) {
        CustomerRSDto customerRSDto = new CustomerRSDto();
        customerRSDto.setCustomer(customerEntity);
        return customerRSDto;
    }

    /*
    @Override
    public BaseDtoMapper<CustomerRSDto,CustomerEntity> getFactory() {
        return customerMapper;
    }
    */

}
