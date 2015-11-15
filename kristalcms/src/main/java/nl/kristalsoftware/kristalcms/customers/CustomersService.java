package nl.kristalsoftware.kristalcms.customers;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerLinkRSDto;
import nl.kristalsoftware.kristalcms.customers.entity.CustomersEntity;
import nl.kristalsoftware.kristalcms.customers.rest.CustomersRSDto;
import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.PathNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomersService extends BaseDataService<CustomersRSDto,CustomersEntity> implements DataService<CustomersRSDto,CustomersEntity> {

    @Inject
    private CustomersDAO customersDAO;

    @Inject
    private DataService<CustomerLinkRSDto,CustomerEntity> customerService;

    @Override
    protected CustomersRSDto setEntity(CustomersEntity entity) {
        CustomersRSDto customersRSDto = new CustomersRSDto();
        List<CustomerLinkRSDto> customerRSDtoList = new ArrayList<CustomerLinkRSDto>();
        List<String> customerPathList = entity.getCustomerEntityList();
        for (String path : customerPathList) {
            CustomerLinkRSDto customerLinkRSDto;
            try {
                customerLinkRSDto = customerService.getData(path);
                customerRSDtoList.add(customerLinkRSDto);
            } catch (PathNotFoundException e) {
                // do nothing
            } catch (CMSDataException e) {
                // do nothing
            }
        }
        customersRSDto.setCustomerList(customerRSDtoList);
        return customersRSDto;
    }

    @Override
    public BaseDAO<CustomersEntity> getDAO() {
        return customersDAO;
    }
}
