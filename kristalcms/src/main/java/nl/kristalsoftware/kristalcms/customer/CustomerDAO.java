package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntityFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomerDAO extends BaseDAO<CustomerEntity> {

    private CustomerEntityFactory customerEntityFactory;

    @Inject
    public CustomerDAO(CustomerEntityFactory customerEntityFactory) {
        this.customerEntityFactory = customerEntityFactory;
    }

    @Override
    protected BaseRootItemEntityFactory<CustomerEntity> getFactory() {
        return customerEntityFactory;
    }
}
