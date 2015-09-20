package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.data.CustomerJcrData;
import nl.kristalsoftware.kristalcms.data.CustomerRSDto;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerJcrEntity implements IBaseJcrEntity<CustomerRSDto> {

    @Inject
    private Logger logger;

    @Inject
    private Session session;

    @Inject
    private CustomerRSDto customerRSDto;

    @Inject
    private CustomerJcrData customerJcrData;

    @Override
    public CustomerRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        customerRSDto.setCustomerId(customerJcrData.getCustomerId(node));
        customerRSDto.setVersion(customerJcrData.getVersion(node));
        customerRSDto.setCity(customerJcrData.getCity(node));
        return customerRSDto;
    }

    @Override
    public String setData(String parentPath, CustomerRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
/*
        Node node = session.getNode(parentPath);
        Node customerNode = node.addNode(data.getNodename());
        newPath = customerNode.getPath();
        this.setJcrValuesFromData(customerNode, data);
*/
        return newPath;
    }

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        node.remove();
        session.save();
    }

}
