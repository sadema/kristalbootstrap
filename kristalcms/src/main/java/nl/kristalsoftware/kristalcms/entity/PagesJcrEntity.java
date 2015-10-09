package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.dto.PageRSDto;
import nl.kristalsoftware.kristalcms.dto.PagesRSDto;
import nl.kristalsoftware.kristalcms.jcrdata.PagesJcrData;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 09-10-15.
 */
public class PagesJcrEntity implements IBaseJcrEntity<PagesRSDto> {

    @Inject
    private Logger logger;

    @Inject
    private PagesJcrData pagesJcrData;

    @Override
    public PagesRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        PagesRSDto pagesRSDto = new PagesRSDto();
        pagesRSDto.setPageList(pagesJcrData.getPageList(path));
        return pagesRSDto;
    }

    @Override
    public String createData(String parentPath, PagesRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        return null;
    }

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {

    }
}
