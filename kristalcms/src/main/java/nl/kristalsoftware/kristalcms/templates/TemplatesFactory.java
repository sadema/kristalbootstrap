package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseFactory;
import nl.kristalsoftware.kristalcms.base.BaseNodeMapper;
import nl.kristalsoftware.kristalcms.template.TemplateEntity;
import nl.kristalsoftware.kristalcms.template.TemplateFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplatesFactory extends BaseNodeMapper<TemplatesEntity> implements BaseFactory<TemplatesEntity> {

    private TemplatesEntity templatesEntity;

    @Inject
    private TemplatesJcrData jcrData;

    @Inject
    private TemplateFactory templateFactory;

    public TemplatesFactory() {
        templatesEntity = new TemplatesEntity();
    }

    protected TemplatesEntity createEntity() throws RepositoryException {
        List<String> templatePathList = templateFactory.createEntityPathList(getPath());
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
