package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 25/10/15.
 */
public class PagesMapper implements BaseMapper<PagesRSDto,PagesUriInfo> {

    @Inject
    private PagesJcrData pagesJcrData;

    @Override
    public PagesRSDto setFieldsInDto(Node node, PagesUriInfo uriInfo) throws PathNotFoundException, RepositoryException {
        PagesRSDto pagesRSDto = new PagesRSDto();
        pagesRSDto.setCustomer(uriInfo.getCustomerId());
        pagesRSDto.setPageList(pagesJcrData.getPageList(uriInfo.getPath()));
        return null;
    }

    @Override
    public void setFieldsInRepository(Node node, PagesRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        // no fields
    }
}
