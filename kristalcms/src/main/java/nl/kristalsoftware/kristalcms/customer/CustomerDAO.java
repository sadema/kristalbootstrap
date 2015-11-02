package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomerDAO extends BaseDAO<CustomerEntity> {

    @Inject
    private CustomerMapper mapper;

    @Override
    protected BaseMapper<CustomerEntity> getMapper() {
        return mapper;
    }
}
