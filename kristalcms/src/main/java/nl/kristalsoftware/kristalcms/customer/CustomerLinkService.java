package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerLinkRSDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerLinkService extends BaseDataService<CustomerLinkRSDto,CustomerEntity> implements DataService<CustomerLinkRSDto,CustomerEntity> {

    @Inject
    private CustomerDAO customerDAO;

    @Override
    public BaseDAO<CustomerEntity> getDAO() {
        return customerDAO;
    }

    protected CustomerLinkRSDto setEntity(CustomerEntity customerEntity) {
        CustomerLinkRSDto customerLinkRSDto = new CustomerLinkRSDto();
        customerLinkRSDto.setCustomer(customerEntity);
        return customerLinkRSDto;
    }

}
