package nl.kristalsoftware.kristalcms.data;

import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="page")
public class PageData {

    @ParentResource
    private CustomerData customer;

    @XmlID
    @XmlAttribute(name="id")
    private String nodename;

    @XmlElement(name="content")
    private String pageContent;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public PageData() {}

    public PageData(CustomerData customer) {
        this.customer = customer;
    }

    public CustomerData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerData customer) {
        this.customer = customer;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}
