package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseFactory;
import nl.kristalsoftware.kristalcms.base.BaseNodeMapper;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplateFactory extends BaseNodeMapper<TemplateEntity> implements BaseFactory<TemplateEntity> {

    private final TemplateEntity templateEntity;

    @Inject
    protected TemplateJcrData jcrData;

    public TemplateFactory() {
        templateEntity = new TemplateEntity();
    }

    protected TemplateEntity createEntity() throws RepositoryException {
        templateEntity.setId(jcrData.getId());
        templateEntity.setTemplateContent(jcrData.getContent());
        return templateEntity;
    }

    @Override
    protected BaseJcrData getJcrData() {
        return jcrData;
    }

    @Override
    protected BaseEntity getBaseEntity() {
        return templateEntity;
    }
}
