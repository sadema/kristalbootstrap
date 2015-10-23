package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public class CustomerMapper implements BaseMapper<CustomerRSDto,CustomerUriInfo> {

    private final CustomerRSDto customerRSDto;

    @Inject
    private CustomerJcrData customerJcrData;

    public CustomerMapper() {
       this.customerRSDto = new CustomerRSDto();
    }

    @Override
    public CustomerRSDto setFieldsInDto(Node node, CustomerUriInfo customerUriInfo) throws PathNotFoundException, RepositoryException {
        customerRSDto.setCustomerId(customerJcrData.getCustomerId(node));
        customerRSDto.setVersion(customerJcrData.getVersion(node));
        customerRSDto.setCity(customerJcrData.getCity(node));
        return customerRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, CustomerRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        customerJcrData.setVersion(node, data.getVersion());
        customerJcrData.setCity(node, data.getCity());
    }
}
