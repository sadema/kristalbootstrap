package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.base.BaseController;
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
public class ContentResource extends BaseResource<ContentRSDto> {

    @AddLinks
    @LinkResources({
            @LinkResource,
            @LinkResource(value = PageRSDto.class, rel = "content")
    })
    @GET
    @Path("{customerId}/pages/{pageId}/content")
    public ContentRSDto getContent(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo) {
        return super.getResourceType(uriInfo.getPath());
    }

    @Override
    protected BaseController<ContentRSDto> getController() {
        return null;
    }
}
