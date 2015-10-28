package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.annotation.Page;
import nl.kristalsoftware.kristalcms.base.BaseUriInfo;

import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 20-10-15.
 */
public class ContentUriInfo implements BaseUriInfo {

    private final String nodename = "content";

    private String customerId;

    private String pageId;

    private UriInfo uriInfo;

    public ContentUriInfo() {}

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
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
        return nodename;
    }

}
