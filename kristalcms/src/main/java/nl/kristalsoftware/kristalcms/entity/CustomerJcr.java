package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.data.CustomerData;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class CustomerJcr implements BaseJcr<CustomerData> {

    @Inject
    private Logger logger;

    @Inject
    private Session session;

    @Inject
    private CustomerData customerData;

    @Override
    public CustomerData getData(String path) {
        try {
            Node node = session.getNode(path);
            customerData.setNodename(node.getName());
            try {
                customerData.setVersion(node.getProperty("version").getString());
            } catch(PathNotFoundException e) {
                logger.info("Property version does not exist");
            } catch (ValueFormatException e) {
                e.printStackTrace();
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
            try {
                customerData.setCity(node.getProperty("city").getString());
            } catch(PathNotFoundException e) {
                logger.info("Property city does not exist");
            } catch (ValueFormatException e) {
                e.printStackTrace();
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        } catch (RepositoryException e) {
        }
        return customerData;
    }
}
