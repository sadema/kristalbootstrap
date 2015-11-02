package nl.kristalsoftware.kristalcms.pages;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseEntity;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class PagesController extends BaseController<PagesRSDto> {

    @Override
    protected <E extends BaseEntity> BaseDataService<PagesRSDto, E> getResourceTypeService() {
        return null;
    }
}
