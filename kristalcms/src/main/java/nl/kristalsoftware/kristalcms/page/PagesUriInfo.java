package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.annotation.Pages;
import nl.kristalsoftware.kristalcms.base.BaseUriInfo;

import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 20-10-15.
 */
@Pages
public class PagesUriInfo implements BaseUriInfo {

    private final String nodeName = "pages";

    private String customerId;

    private UriInfo uriInfo;

    public PagesUriInfo() {}

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
