package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.base.BaseNodeMapper;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class CustomerMapper extends BaseNodeMapper<CustomerEntity> implements BaseMapper<CustomerEntity> {

    private final CustomerEntity customerEntity;

    @Inject
    private CustomerJcrData jcrData;

    public CustomerMapper() {
        customerEntity = new CustomerEntity();
    }

    protected CustomerEntity getEntity() throws RepositoryException {
        customerEntity.setId(jcrData.getCustomerId());
        customerEntity.setCity(jcrData.getCity());
        customerEntity.setVersion(jcrData.getVersion());
        return customerEntity;
    }

    @Override
    public BaseJcrData getJcrData() {
        return jcrData;
    }

    @Override
    public BaseEntity getBaseEntity() {
        return customerEntity;
    }
}
