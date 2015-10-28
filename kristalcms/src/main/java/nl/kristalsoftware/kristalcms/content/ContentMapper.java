package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.annotation.Content;
import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 26/10/15.
 */
@Content
public class ContentMapper implements BaseMapper<ContentRSDto,ContentUriInfo> {

    @Override
    public ContentRSDto setFieldsInDto(Node node, ContentUriInfo uriInfo) throws PathNotFoundException, RepositoryException {
        ContentRSDto contentRSDto = new ContentRSDto();
        return contentRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, ContentRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {

    }
}
