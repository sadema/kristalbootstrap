package nl.kristalsoftware.kristalcms.resource;

import nl.kristalsoftware.kristalcms.dto.CustomerRSDto;
import nl.kristalsoftware.kristalcms.dto.TemplateRSDto;
import nl.kristalsoftware.kristalcms.dto.TemplatesRSDto;
import nl.kristalsoftware.kristalcms.entity.IBaseService;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 29-09-15.
 */
public class TemplateResourceImpl implements ITemplateResource {

    @Inject
    private Logger logger;

    @Inject
    private IBaseService<TemplateRSDto> templateJcr;

    @Override
    public TemplatesRSDto getTemplates(String customerId, @Context UriInfo uriInfo) {
        TemplatesRSDto templatesRSDto = null;
        CustomerRSDto customerRSDto = new CustomerRSDto(customerId);
        // TODO Sjoerd: refactor naar templatesJcr
        templatesRSDto = new TemplatesRSDto();
        templatesRSDto.setCustomer(customerId);
        return templatesRSDto;
    }

    @Override
    public String getTemplate(String customerId, String templateId, @Context UriInfo uriInfo) {
        String content = null;
        String path = this.removeFromLastFoundCharacter(this.removeFromLastFoundCharacter(uriInfo.getPath(), '_'), '_');
        logger.info("Path: " + path);
        try {
            TemplateRSDto templateRSDto = templateJcr.getData(path);
            content = templateRSDto.getTemplateContent();
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return content;
    }

    private String removeFromLastFoundCharacter(String path, char c) {
        String newPath = path;
        int index = path.lastIndexOf('_');
        if (index > 0) {
            newPath = path.substring(0, index);
        }
        return newPath;
    }

    @Override
    public Response createTemplate(String customerId, TemplateRSDto templateRSDto, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            String newPath = templateJcr.createData(uriInfo.getPath(), templateRSDto);
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
    public Response removeTemplate(String customerId, String templateId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            templateJcr.removeData(uriInfo.getPath());
            response = Response.noContent().build();
            response = Response.noContent().build();
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
