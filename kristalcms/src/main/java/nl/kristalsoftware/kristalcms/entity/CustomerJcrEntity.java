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
public class CustomerJcrEntity implements BaseJcrEntity<CustomerData> {

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
    public CustomerData getData(String path) {
        try {
            Node node = session.getNode(path);
            customerData.setNodename(node.getName());
            customerData.setVersion(version.getData(node, "version"));
            customerData.setCity(city.getData(node, "city"));
        } catch (RepositoryException e) {
        }
        return customerData;
    }
}
