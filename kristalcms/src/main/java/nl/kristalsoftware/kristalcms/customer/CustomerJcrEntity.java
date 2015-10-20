package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.DataService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerJcrEntity implements DataService<CustomerRSDto> {

    @Inject
    private Logger logger;

    @Inject
    private Session session;

    @Inject
    private CustomerJcrData customerJcrData;

    @Override
    public CustomerRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        CustomerRSDto customerRSDto = new CustomerRSDto();
        Node node = session.getNode(path);
        customerRSDto.setCustomerId(customerJcrData.getCustomerId(node));
        customerRSDto.setVersion(customerJcrData.getVersion(node));
        customerRSDto.setCity(customerJcrData.getCity(node));
        return customerRSDto;
    }

    @Override
    public String createData(String parentPath, CustomerRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        Node customerNode = node.addNode(data.getCustomerId());
        newPath = customerNode.getPath();
        customerJcrData.setVersion(customerNode, data.getVersion());
        customerJcrData.setCity(customerNode, data.getCity());
        return newPath;
    }

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        node.remove();
        session.save();
    }

}
