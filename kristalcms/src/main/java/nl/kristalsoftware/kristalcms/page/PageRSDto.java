package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;
import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="page")
public class PageRSDto {

    @ParentResource
    private CustomerRSDto customerRSDto = new CustomerRSDto();

    @XmlID
    @XmlAttribute(name="id")
    private String pageId;

    @XmlElement(name="content")
    private String pageContent;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public PageRSDto() {}

    public PageRSDto(String pageId) {
        this.pageId = pageId;
    }

    public void setCustomerId(String customerId) {
        customerRSDto.setCustomerId(customerId);
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}
