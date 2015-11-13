package nl.kristalsoftware.kristalcms.templates.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.entity.RootItemEntityFactory;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntityFactory;
import nl.kristalsoftware.kristalcms.templates.jcr.TemplatesJcrData;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplatesEntityFactory extends RootItemEntityFactory<TemplatesEntity> {

    private TemplatesEntity templatesEntity;

    private TemplatesJcrData jcrData;

    @Inject
    private TemplateEntityFactory templateEntityFactory;

    @Inject
    public TemplatesEntityFactory(Session session, TemplatesJcrData templatesJcrData) {
        super(session);
        templatesEntity = new TemplatesEntity();
        jcrData = templatesJcrData;
    }

    protected TemplatesEntity createEntity() throws RepositoryException {
        templatesEntity.setId(jcrData.getId());
        List<String> templatePathList = templateEntityFactory.createEntityPathList(getPath());
        templatesEntity.setTemplateEntityList(templatePathList);
        return templatesEntity;
    }

    @Override
    protected BaseJcrData getJcrData() {
        return jcrData;
    }

    @Override
    protected BaseEntity getBaseEntity() {
        return templatesEntity;
    }
}
