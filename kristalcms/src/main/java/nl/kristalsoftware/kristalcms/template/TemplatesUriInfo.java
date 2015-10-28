package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.Page;
import nl.kristalsoftware.kristalcms.base.BaseUriInfo;

import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 20-10-15.
 */
public class TemplatesUriInfo implements BaseUriInfo {

    private final String nodeName = "templates";

    private String customerId;

    private UriInfo uriInfo;

    public TemplatesUriInfo() {}

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        return nodeName;
    }

}
