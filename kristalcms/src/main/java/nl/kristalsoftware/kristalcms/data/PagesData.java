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
    private CustomerRSDto customer;

    private String nodename = "pages";

    @XmlElement(name="page")
    private List<PageRSDto> pageList = new ArrayList<PageRSDto>();

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public PagesData() {}

    public PagesData(CustomerRSDto customer) {
        this.customer = customer;
    }

    public CustomerRSDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRSDto customer) {
        this.customer = customer;
    }

    public String getNodename() {
        return nodename;
    }

    public List<PageRSDto> getPageList() {
        return pageList;
    }

    public void setPageList(List<PageRSDto> pageList) {
        this.pageList = pageList;
    }
}
