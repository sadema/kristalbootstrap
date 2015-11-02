package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.BaseDtoMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 25/10/15.
 */
public class PageDtoMapper { //implements BaseDtoMapper<PageRSDto,PageUriInfo> {

    /*
    @Inject
    private PageJcrData pageJcrData;

    @Override
    public PageRSDto setFieldsInDto(Node node, PageUriInfo uriInfo) throws PathNotFoundException, RepositoryException {
        PageRSDto pageRSDto = new PageRSDto();
        pageRSDto.setCustomerId(uriInfo.getCustomerId());
        pageRSDto.setPageId(uriInfo.getPageId());
        pageRSDto.setPageContent(pageJcrData.getContent(node));
        return pageRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, PageRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {

    }
    */
}
