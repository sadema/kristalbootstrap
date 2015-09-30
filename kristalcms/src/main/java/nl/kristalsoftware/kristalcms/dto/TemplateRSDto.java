package nl.kristalsoftware.kristalcms.dto;

import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="template")
public class TemplateRSDto {

    @ParentResource
    private CustomerRSDto customerRSDto = new CustomerRSDto();

    @XmlID
    @XmlAttribute(name="id")
    private String templateId;

    @XmlElement(name="content")
    private String templateContent;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public TemplateRSDto() {}

    public void setCustomerId(String customerId) {
        customerRSDto.setCustomerId(customerId);
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }
}
