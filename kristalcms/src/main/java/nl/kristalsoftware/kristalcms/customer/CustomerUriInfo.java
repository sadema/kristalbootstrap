package nl.kristalsoftware.kristalcms.customer;

import nl.kristalsoftware.kristalcms.annotation.Pages;
import nl.kristalsoftware.kristalcms.base.BaseUriInfo;

import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 20-10-15.
 */
public class CustomerUriInfo implements BaseUriInfo {

    private String customerId;

    private UriInfo uriInfo;

    public CustomerUriInfo() {}

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

    @Override
    public String getPath() {
        return uriInfo.getPath();
    }

    @Override
    public String getNodename() {
        return getCustomerId();
    }

}
