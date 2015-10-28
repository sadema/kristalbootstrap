package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.page.PageRSDto;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import org.jboss.resteasy.links.LinkResources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 19-10-15.
 */
public class ContentResource extends BaseResource<ContentRSDto,ContentUriInfo> {

    @Inject
    private BaseDataService<ContentRSDto,ContentUriInfo> contentService;

    @Inject
    private ContentUriInfo contentUriInfo;

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = PageRSDto.class, rel = "content")
    })
    @GET
    @Path("{customerId}/pages/{pageId}/content")
    public ContentRSDto getContent(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo) {
        contentUriInfo.setCustomerId(customerId);
        contentUriInfo.setPageId(pageId);
        contentUriInfo.setUriInfo(uriInfo);
        return super.getResourceType();
    }

    @Override
    protected BaseDataService<ContentRSDto, ContentUriInfo> getResourceTypeService() {
        return contentService;
    }

    @Override
    protected ContentUriInfo getResourceUriInfo() {
        return contentUriInfo;
    }
}
