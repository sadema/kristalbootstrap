package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 27/10/15.
 */
public class TemplatesMapper implements BaseMapper<TemplatesRSDto,TemplatesUriInfo> {
    @Override
    public TemplatesRSDto setFieldsInDto(Node node, TemplatesUriInfo uriInfo) throws PathNotFoundException, RepositoryException {
        TemplatesRSDto templatesRSDto = new TemplatesRSDto();
        return templatesRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, TemplatesRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {

    }
}
