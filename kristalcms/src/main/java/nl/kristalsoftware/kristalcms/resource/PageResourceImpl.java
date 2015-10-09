package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.dto.CustomerRSDto;
import nl.kristalsoftware.kristalcms.dto.PageRSDto;
import nl.kristalsoftware.kristalcms.dto.PagesRSDto;
import nl.kristalsoftware.kristalcms.entity.IBaseJcrEntity;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by sjoerdadema on 15-09-15.
 */
public class PageResourceImpl implements IPageResource {

    @Inject
    private IBaseJcrEntity<PagesRSDto> pagesJcr;

    @Inject
    private IBaseJcrEntity<PageRSDto> pageJcr;

    @Override
    public PagesRSDto getPages(String customerId, @Context UriInfo uriInfo) {
        PagesRSDto pagesRSDto = null;
        try {
            pagesRSDto = pagesJcr.getData(uriInfo.getPath());
            pagesRSDto.setCustomer(customerId);
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return pagesRSDto;
    }

    @Override
    public PageRSDto getPage(String customerId, String pageId, @Context UriInfo uriInfo) {
        PageRSDto pageRSDto = null;
        try {
            pageRSDto = pageJcr.getData(uriInfo.getPath());
            pageRSDto.setCustomerId(customerId);
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return pageRSDto;
    }

    @Override
    public Response createPage(String customerId, PageRSDto pageRSDto, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            String newPath = pageJcr.createData(uriInfo.getPath(), pageRSDto);
            if (newPath != null) {
                response = Response.created(URI.create(newPath)).build();
            }
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (ItemExistsException e) {
            throw new WebApplicationException(422);     // unprocessable entity
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public Response removePage(String customerId, String pageId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            pageJcr.removeData(uriInfo.getPath());
            response = Response.noContent().build();
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
