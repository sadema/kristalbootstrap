package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseEntity;

/**
 * Created by sjoerdadema on 19-10-15.
 */
public class ContentService extends BaseDataService<ContentRSDto,Content> {

    @Override
    protected ContentRSDto setEntity(Content entity) {
        return null;
    }

    @Override
    public <E extends BaseEntity> BaseDAO<E> getDAO() {
        return null;
    }
}
