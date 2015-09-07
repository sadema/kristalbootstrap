package nl.kristalsoftware.kristalcms.data;

import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 07-09-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Customer {

    @XmlID
    @XmlAttribute(name="id")
    private String nodename;

    @XmlElement
    private String city = "Nunspeet";

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public Customer() {}

    public Customer(String customerId) {
        nodename = customerId;
    }
}
