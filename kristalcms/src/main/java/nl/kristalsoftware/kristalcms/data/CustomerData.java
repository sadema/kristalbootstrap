package nl.kristalsoftware.kristalcms.data;

import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customer")
public class CustomerData {

    @XmlID
    @XmlAttribute(name="id")
    private String nodename;

    @XmlElement
    private String version;

    @XmlElement
    private String city;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public CustomerData() {}

    public CustomerData(String customerId) {
        nodename = customerId;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
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
}
