package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.data.CustomerData;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerJcrEntity implements IBaseJcrEntity<CustomerData> {

    @Inject
    private Logger logger;

    @Inject
    private Session session;

    @Inject
    private CustomerData customerData;

    @Inject
    private JcrProperty<String> version;

    @Inject
    private JcrProperty<String> city;

    @Override
    public CustomerData getData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        this.setDataFromJcrValues(node);
        return customerData;
    }

    @Override
    public String setData(String parentPath, CustomerData data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        Node node = session.getNode(parentPath);
        Node customerNode = node.addNode(data.getNodename());
        newPath = customerNode.getPath();
        this.setJcrValuesFromData(customerNode, data);
        return newPath;
    }

    @Override
    public void setDataFromJcrValues(Node node) throws PathNotFoundException, RepositoryException {
        customerData.setNodename(node.getName());
        customerData.setVersion(version.getPropertyValue(node, "version"));
        customerData.setCity(city.getPropertyValue(node, "city"));
    }

    @Override
    public void setJcrValuesFromData(Node node, CustomerData data) throws PathNotFoundException, RepositoryException {
        version.setPropertyValue(node, "version", data.getVersion());
        city.setPropertyValue(node, "city", data.getCity());
    }
}
