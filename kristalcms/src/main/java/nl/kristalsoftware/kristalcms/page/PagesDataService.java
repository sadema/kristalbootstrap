package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.DataService;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 09-10-15.
 */
public class PagesDataService implements DataService<PagesRSDto> {

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
