package nl.kristalsoftware.kristalcms.data;

import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="pages")
public class PagesData {

    @ParentResource
    private CustomerData customer;

    private String nodename = "pages";

    @XmlElement(name="page")
    private List<PageData> pageList = new ArrayList<PageData>();

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public PagesData() {}

    public PagesData(CustomerData customer) {
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

    public List<PageData> getPageList() {
        return pageList;
    }

    public void setPageList(List<PageData> pageList) {
        this.pageList = pageList;
    }
}
