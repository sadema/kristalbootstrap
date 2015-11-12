package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseFactory;
import nl.kristalsoftware.kristalcms.base.BaseEntityFactory;
import nl.kristalsoftware.kristalcms.template.TemplateEntityFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplatesFactory extends BaseEntityFactory<TemplatesEntity> implements BaseFactory<TemplatesEntity> {

    private TemplatesEntity templatesEntity;

    @Inject
    private TemplatesJcrData jcrData;

    @Inject
    private TemplateEntityFactory templateEntityFactory;

    @Inject
    public TemplatesFactory(Session session) {
        super(session);
        templatesEntity = new TemplatesEntity();
    }

    protected TemplatesEntity createEntity() throws RepositoryException {
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
