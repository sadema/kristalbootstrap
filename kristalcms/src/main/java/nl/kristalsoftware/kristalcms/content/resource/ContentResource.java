package nl.kristalsoftware.kristalcms.content.resource;

import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.content.ContentRSDto;
import nl.kristalsoftware.kristalcms.content.resource.ContentResourceDefinition;

import javax.inject.Inject;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 19-10-15.
 */
public class ContentResource implements ContentResourceDefinition {

    @Inject
    private DataService<ContentRSDto> contentService;

    @Override
    public ContentRSDto getContent(String customerId, String pageId, @Context UriInfo uriInfo) {
        ContentRSDto contentRSDto = null;
        try {
            contentRSDto = contentService.getData(uriInfo.getPath());
            contentRSDto.setPageId(pageId);
            contentRSDto.getPageRSDto().setCustomerId(customerId);
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return null;
    }

}
