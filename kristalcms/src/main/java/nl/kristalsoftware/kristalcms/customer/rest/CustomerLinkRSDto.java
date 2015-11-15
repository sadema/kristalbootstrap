package nl.kristalsoftware.kristalcms.customer.rest;

import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customer")
public class CustomerLinkRSDto {

    @XmlID
    @XmlAttribute(name="id")
    private String customerId;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public CustomerLinkRSDto() {}

    public CustomerLinkRSDto(String customerId) {
        customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomer(CustomerEntity customerEntity) {
        setCustomerId(customerEntity.getId());
    }

}
