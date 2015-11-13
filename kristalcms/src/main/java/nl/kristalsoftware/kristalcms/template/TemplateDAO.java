package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntity;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntityFactory;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class TemplateDAO extends BaseDAO<TemplateEntity> {

    private TemplateEntityFactory templateEntityFactory;

    @Inject
    public TemplateDAO(TemplateEntityFactory templateEntityFactory) {
        this.templateEntityFactory = templateEntityFactory;
    }

    @Override
    protected BaseRootItemEntityFactory<TemplateEntity> getFactory() {
        return templateEntityFactory;
    }
}
