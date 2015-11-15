package nl.kristalsoftware.kristalcms.customers.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.entity.RootItemEntityFactory;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntityFactory;
import nl.kristalsoftware.kristalcms.customers.jcr.CustomersJcrData;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class CustomersEntityFactory extends RootItemEntityFactory<CustomersEntity> {

    private CustomersEntity customersEntity;

    private CustomersJcrData jcrData;

    @Inject
    private CustomerEntityFactory customerEntityFactory;

    @Inject
    public CustomersEntityFactory(Session session, CustomersJcrData customersJcrData) {
        super(session);
        customersEntity = new CustomersEntity();
        jcrData = customersJcrData;
    }

    protected CustomersEntity createEntity() throws RepositoryException {
        customersEntity.setId(jcrData.getId());
        List<String> templatePathList = customerEntityFactory.createEntityPathList(getPath());
        customersEntity.setCustomerEntityList(templatePathList);
        return customersEntity;
    }

    @Override
    protected BaseJcrData getJcrData() {
        return jcrData;
    }

    @Override
    protected BaseEntity getBaseEntity() {
        return customersEntity;
    }
}
