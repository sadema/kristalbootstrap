package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseFactory;
import nl.kristalsoftware.kristalcms.base.BaseEntityFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplateEntityFactory extends BaseEntityFactory<TemplateEntity> implements BaseFactory<TemplateEntity> {

    private final TemplateEntity templateEntity;

    //@Inject
    protected TemplateJcrData jcrData;

    @Inject
    public TemplateEntityFactory(Session session, TemplateJcrData jcrData) {
        super(session);
        templateEntity = new TemplateEntity();
        this.jcrData = jcrData;
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
