package nl.kristalsoftware.kristalcms.pages;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseDtoMapper;
import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.pages.PagesRSDto;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 09-10-15.
 */
public class PagesService extends BaseDataService<PagesRSDto,Pages> {

    @Override
    protected PagesRSDto setEntity(Pages entity) {
        return null;
    }

    @Override
    public <E extends BaseEntity> BaseDAO<E> getDAO() {
        return null;
    }
}
