package nl.kristalsoftware.kristalcms.customers;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
import nl.kristalsoftware.kristalcms.customers.entity.CustomersEntity;
import nl.kristalsoftware.kristalcms.customers.entity.CustomersEntityFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomersDAO extends BaseDAO<CustomersEntity> {

    @Inject
    private CustomersEntityFactory factory;

    @Override
    protected BaseRootItemEntityFactory<CustomersEntity> getFactory() {
        return factory;
    }
}
