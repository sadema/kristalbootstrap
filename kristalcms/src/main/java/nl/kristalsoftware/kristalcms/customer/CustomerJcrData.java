package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.NodeJcrData;
import nl.kristalsoftware.kristalcms.corejcr.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 19-09-15.
 */
public class CustomerJcrData extends NodeJcrData implements BaseJcrData {

    @Inject
    private JcrProperty<String> version;

    @Inject
    private JcrProperty<String> city;

    public String getCustomerId() throws RepositoryException {
        return node.getName();
    }

    public void setCustomerId(String value) throws RepositoryException {
    }

    public String getVersion() throws RepositoryException {
        return city.getPropertyValue(node, "version");
    }

    public void setVersion(String value) throws RepositoryException {
        city.setPropertyValue(node, "version", value);
    }

    public String getCity() throws RepositoryException {
        return city.getPropertyValue(node, "city");
    }

    public void setCity(String value) throws RepositoryException {
        city.setPropertyValue(node, "city", value);
    }

}
