package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;
import nl.kristalsoftware.kristalcms.template.TemplateRSDto;
import nl.kristalsoftware.kristalcms.templates.TemplatesEntity;
import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="templates")
public class TemplatesRSDto {

    @ParentResource
    private CustomerRSDto customerRSDto = new CustomerRSDto();

    private String templatesId;

    @XmlElement(name="template")
    private List<TemplateRSDto> templateList = new ArrayList<TemplateRSDto>();

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public TemplatesRSDto() {}

    public void setCustomer(String customerId) {
        customerRSDto.setCustomerId(customerId);
    }

    public String getTemplatesId() {
        return templatesId;
    }

    public void setTemplatesId(String templatesId) {
        this.templatesId = templatesId;
    }

    public List<TemplateRSDto> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<TemplateRSDto> templateList) {
        this.templateList = templateList;
    }

    public void setTemplatesEntity(TemplatesEntity entity) {
        setTemplatesId(entity.getId());
    }
}
