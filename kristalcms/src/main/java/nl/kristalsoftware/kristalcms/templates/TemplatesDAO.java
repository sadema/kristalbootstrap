package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
import nl.kristalsoftware.kristalcms.templates.entity.TemplatesEntity;
import nl.kristalsoftware.kristalcms.templates.entity.TemplatesEntityFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class TemplatesDAO extends BaseDAO<TemplatesEntity> {

    @Inject
    private TemplatesEntityFactory factory;

    @Override
    protected BaseRootItemEntityFactory<TemplatesEntity> getFactory() {
        return factory;
    }
}
