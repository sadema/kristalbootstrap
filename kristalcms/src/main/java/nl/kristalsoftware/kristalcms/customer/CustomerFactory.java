package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseFactory;
import nl.kristalsoftware.kristalcms.base.BaseNodeMapper;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class CustomerFactory extends BaseNodeMapper<CustomerEntity> implements BaseFactory<CustomerEntity> {

    private final CustomerEntity customerEntity;

    @Inject
    private CustomerJcrData jcrData;

    public CustomerFactory() {
        customerEntity = new CustomerEntity();
    }

    protected CustomerEntity createEntity() throws RepositoryException {
        customerEntity.setId(jcrData.getId());
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
