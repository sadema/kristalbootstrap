package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.BaseFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class TemplateDAO extends BaseDAO<TemplateEntity> {

    @Inject
    private TemplateEntityFactory templateEntityFactory;

    @Override
    protected BaseFactory<TemplateEntity> getFactory() {
        return templateEntityFactory;
    }
}
