package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDtoMapper;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 23/10/15.
 */
public class CustomerDtoMapper implements BaseDtoMapper<CustomerRSDto,CustomerEntity> {

    private final CustomerRSDto customerRSDto;

    public CustomerDtoMapper() {
       this.customerRSDto = new CustomerRSDto();
    }

    @Override
    public CustomerRSDto setFieldsInDto(CustomerEntity customerEntity) throws PathNotFoundException, RepositoryException {
        /*
        CustomerRSDto customerRSDto = new CustomerRSDto();
        customerRSDto.setCustomerId(customerEntity.getId());
        customerRSDto.setVersion(customerEntity.getVersion());
        customerRSDto.setCity(customerEntity.getCity());
        */
        return customerRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, CustomerRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        //customerJcrData.setVersion(node, data.getVersion());
        //customerJcrData.setCity(node, data.getCity());
    }
}
