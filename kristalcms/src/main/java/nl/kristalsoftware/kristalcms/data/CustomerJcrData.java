package nl.kristalsoftware.kristalcms.data;

import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 19-09-15.
 */
public class CustomerJcrData {

    @Inject
    private JcrProperty<String> version;

    @Inject
    private JcrProperty<String> city;

    public String getCustomerId(Node node) throws RepositoryException {
        return node.getName();
    }

    public void setCustomerId(Node node, String value) throws RepositoryException {
    }

    public String getVersion(Node node) throws RepositoryException {
        return city.getPropertyValue(node, "version");
    }

    public void setVersion(Node node, String value) throws RepositoryException {
        city.setPropertyValue(node, "version", value);
    }

    public String getCity(Node node) throws RepositoryException {
        return city.getPropertyValue(node, "city");
    }

    public void setCity(Node node, String value) throws RepositoryException {
        city.setPropertyValue(node, "city", value);
    }
}
