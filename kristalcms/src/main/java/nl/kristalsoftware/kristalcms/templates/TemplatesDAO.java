package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class TemplatesDAO extends BaseDAO<TemplatesEntity> {

    @Inject
    private TemplatesFactory factory;

    @Override
    protected BaseFactory<TemplatesEntity> getFactory() {
        return factory;
    }
}
