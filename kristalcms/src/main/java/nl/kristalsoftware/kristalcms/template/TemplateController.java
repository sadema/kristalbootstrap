package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntity;
import nl.kristalsoftware.kristalcms.template.rest.TemplateRSDto;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplateController extends BaseController<TemplateRSDto> {

    @Inject
    private TemplateService templateService;

    @Override
    protected BaseDataService<TemplateRSDto, TemplateEntity> getResourceTypeService() {
        return templateService;
    }
}
