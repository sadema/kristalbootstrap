package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomerDAO extends BaseDAO<CustomerEntity> {

    @Inject
    private CustomerFactory mapper;

    @Override
    protected BaseFactory<CustomerEntity> getFactory() {
        return mapper;
    }
}
