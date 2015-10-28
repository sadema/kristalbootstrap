package nl.kristalsoftware.kristalcms.base;

import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by sjoerdadema on 20-10-15.
 */
public abstract class BaseResource<T,U extends BaseUriInfo> {

    public T getResourceType() {
        T resourceType = null;
        try {
            resourceType = getResourceTypeService().getData(getResourceUriInfo());
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return resourceType;
    }

    public Response createResourceType(T resourceDTO) {
        Response response = null;
        try {
            String newPath = getResourceTypeService().createData(getResourceUriInfo(), resourceDTO);//templateJcr.createData(uriInfo.getPath(), templateRSDto);
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

    public Response removeResourceType() {
        Response response = null;
        try {
            getResourceTypeService().removeData(getResourceUriInfo());
            response = Response.noContent().build();
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;

    }

    abstract protected BaseDataService<T,U> getResourceTypeService();

    abstract protected U getResourceUriInfo();
}
