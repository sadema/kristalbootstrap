package nl.kristalsoftware.kristalcms.customer.rest;

import nl.kristalsoftware.kristalcms.customer.entity.CustomerEntity;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customer")
public class CustomerRSDto {

    @XmlID
    @XmlAttribute(name="id")
    private String customerId;

    @XmlElement
    private String version;

    @XmlElement
    private String city;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public CustomerRSDto() {}

    public CustomerRSDto(String customerId) {
        customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCustomer(CustomerEntity customerEntity) {
        setCustomerId(customerEntity.getId());
        setVersion(customerEntity.getVersion());
        setCity(customerEntity.getCity());
    }

}
