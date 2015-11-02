package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.base.BaseNodeMapper;

import javax.inject.Inject;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplatesMapper extends BaseNodeMapper<TemplatesEntity> implements BaseMapper<TemplatesEntity> {

    private TemplatesEntity templatesEntity;

    @Inject
    private TemplatesJcrData jcrData;

    public TemplatesMapper() {
        templatesEntity = new TemplatesEntity();
    }

    protected TemplatesEntity getEntity() throws RepositoryException {
        //templatesEntity.setCustomerId(jcrData.getCustomerId());
        return templatesEntity;
    }

    @Override
    public BaseJcrData getJcrData() {
        return jcrData;
    }

    @Override
    public BaseEntity getBaseEntity() {
        return templatesEntity;
    }
}
