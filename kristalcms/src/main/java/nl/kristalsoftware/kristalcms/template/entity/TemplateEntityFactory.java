package nl.kristalsoftware.kristalcms.template.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.ItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.template.jcr.TemplateJcrData;
import nl.kristalsoftware.kristalcms.templates.jcr.TemplatesJcrData;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by sjoerdadema on 29/10/15.
 */
public class TemplateEntityFactory extends ItemEntityFactory<TemplateEntity> {

    private final TemplateEntity templateEntity;

    private TemplateJcrData jcrData;

    @Inject
    private TemplatesJcrData parentJcrData;

    @Inject
    public TemplateEntityFactory(Session session, TemplateJcrData templateJcrData) {
        super(session);
        templateEntity = new TemplateEntity();
        jcrData = templateJcrData;
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
    protected List<Node> getJcrNodeList(Session session, String parentPath) throws RepositoryException {
        return parentJcrData.getJcrList().getList(session, parentPath);
    }

    @Override
    protected BaseEntity getBaseEntity() {
        return templateEntity;
    }
}
