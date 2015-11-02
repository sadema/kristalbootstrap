package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class TemplatesDAO extends BaseDAO<TemplatesEntity> {

    @Inject
    private TemplatesMapper mapper;

    @Override
    protected BaseMapper<TemplatesEntity> getMapper() {
        return mapper;
    }
}
