package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.Page;
import nl.kristalsoftware.kristalcms.base.BaseUriInfo;

import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 20-10-15.
 */
@Page
public class TemplateUriInfo implements BaseUriInfo {

    private String customerId;

    private String templateId;

    private UriInfo uriInfo;

    public TemplateUriInfo() {}

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public UriInfo getUriInfo() {
        return uriInfo;
    }

    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    public String getPath() {
        return uriInfo.getPath();
    }

    @Override
    public String getNodename() {
        return getTemplateId();
    }

}
