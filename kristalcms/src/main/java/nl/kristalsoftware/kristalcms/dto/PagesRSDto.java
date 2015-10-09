package nl.kristalsoftware.kristalcms.dto;

import nl.kristalsoftware.kristalcms.dto.PageRSDto;
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
public class PagesRSDto {

    @ParentResource
    private CustomerRSDto customerRSDto = new CustomerRSDto();

    private String pagesId = "pages";

    @XmlElement(name="page")
    private List<PageRSDto> pageList = new ArrayList<PageRSDto>();

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public PagesRSDto() {}

    public void setCustomer(String customerId) {
        customerRSDto.setCustomerId(customerId);
        for (PageRSDto page : pageList) {
            page.setCustomerId(customerId);
        }
    }

    public String getPagesId() {
        return pagesId;
    }

    public List<PageRSDto> getPageList() {
        return pageList;
    }

    public void setPageList(List<PageRSDto> pageList) {
        this.pageList = pageList;
    }

}
