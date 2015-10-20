package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.base.DataService;

import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 19-10-15.
 */
public class ContentDataService implements DataService<ContentRSDto> {
    @Override
    public ContentRSDto getData(String path) throws PathNotFoundException, RepositoryException {
        return null;
    }

    @Override
    public String createData(String parentPath, ContentRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        return null;
    }

    @Override
    public void removeData(String path) throws PathNotFoundException, RepositoryException {

    }
}
