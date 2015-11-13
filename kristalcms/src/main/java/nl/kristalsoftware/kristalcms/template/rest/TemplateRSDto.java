package nl.kristalsoftware.kristalcms.template.rest;

import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntity;
import nl.kristalsoftware.kristalcms.templates.rest.TemplatesRSDto;
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
    private TemplatesRSDto templatesRSDto = new TemplatesRSDto();

    private CustomerRSDto customerRSDto = new CustomerRSDto();

    @XmlID
    @XmlAttribute(name="id")
    private String templateId = "main";

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

    private void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    private void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public void setTemplateEntity(TemplateEntity templateEntity) {
        setTemplateId(templateEntity.getId());
        setTemplateContent(templateEntity.getTemplateContent());
    }

}
