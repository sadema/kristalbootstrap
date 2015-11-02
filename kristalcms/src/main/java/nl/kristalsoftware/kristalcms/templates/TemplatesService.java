package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class TemplatesService extends BaseDataService<TemplatesRSDto,TemplatesEntity> implements DataService<TemplatesRSDto,TemplatesEntity> {

    @Inject
    private TemplatesDAO templatesDAO;

    @Override
    protected TemplatesRSDto setEntity(TemplatesEntity entity) {
        TemplatesRSDto templatesRSDto = new TemplatesRSDto();
        templatesRSDto.setTemplatesEntity(entity);
        return templatesRSDto;
    }

    @Override
    public BaseDAO<TemplatesEntity> getDAO() {
        return templatesDAO;
    }
}
