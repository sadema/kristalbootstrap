package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.*;
import nl.kristalsoftware.kristalcms.main.CMSDataException;
import nl.kristalsoftware.kristalcms.template.rest.TemplateRSDto;
import nl.kristalsoftware.kristalcms.template.TemplateService;
import nl.kristalsoftware.kristalcms.templates.entity.TemplatesEntity;
import nl.kristalsoftware.kristalcms.templates.rest.TemplatesRSDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jcr.PathNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class TemplatesService extends BaseDataService<TemplatesRSDto,TemplatesEntity> implements DataService<TemplatesRSDto,TemplatesEntity> {

    @Inject
    private TemplatesDAO templatesDAO;

    @Inject
    private TemplateService templateService;

    @Override
    protected TemplatesRSDto setEntity(TemplatesEntity entity) {
        TemplatesRSDto templatesRSDto = new TemplatesRSDto();
        List<TemplateRSDto> templateRSDtoList = new ArrayList<TemplateRSDto>();
        List<String> templatePathList = entity.getTemplateEntityList();
        for (String path : templatePathList) {
            TemplateRSDto templateRSDto;
            try {
                templateRSDto = templateService.getData(path);
                templateRSDtoList.add(templateRSDto);
            } catch (PathNotFoundException e) {
                // do nothing
            } catch (CMSDataException e) {
                // do nothing
            }
        }
        templatesRSDto.setTemplateList(templateRSDtoList);
        return templatesRSDto;
    }

    @Override
    public BaseDAO<TemplatesEntity> getDAO() {
        return templatesDAO;
    }
}
