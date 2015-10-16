package nl.kristalsoftware.kristalcms.dto;

import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="page")
public class CreatePageRSDto {

    @XmlID
    @XmlAttribute(name="id")
    private String pageId;

    @XmlElement(name="template")
    private String templateName;

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public CreatePageRSDto() {}

    public CreatePageRSDto(String pageId) {
        this.pageId = pageId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
