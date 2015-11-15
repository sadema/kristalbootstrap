package nl.kristalsoftware.kristalcms.customer.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.entity.ItemEntityFactory;
import nl.kristalsoftware.kristalcms.customer.jcr.CustomerJcrData;
import nl.kristalsoftware.kristalcms.property.JcrList;
import nl.kristalsoftware.kristalcms.property.JcrNodeList;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class CustomerEntityFactory extends ItemEntityFactory<CustomerEntity> {

    private final CustomerEntity customerEntity;

    private CustomerJcrData jcrData;

    @Inject
    public CustomerEntityFactory(Session session, CustomerJcrData customerJcrData) {
        super(session);
        customerEntity = new CustomerEntity();
        jcrData = customerJcrData;
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
    protected List<Node> getJcrNodeList(Session session, String parentPath) throws RepositoryException {

        JcrList jcrList = new JcrNodeList();
        return jcrList.getList(session, parentPath);
    }

    @Override
    public BaseEntity getBaseEntity() {
        return customerEntity;
    }
}
