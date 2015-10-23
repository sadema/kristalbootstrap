package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.base.DataService;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 09-10-15.
 */
public class PagesDtoService extends BaseDataService<PagesRSDto,PagesUriInfo> {

    @Inject
    private BaseMapper<PagesRSDto,PagesUriInfo> mapper;

    @Override
    public BaseMapper<PagesRSDto, PagesUriInfo> getMapper() {
        return mapper;
    }

}
