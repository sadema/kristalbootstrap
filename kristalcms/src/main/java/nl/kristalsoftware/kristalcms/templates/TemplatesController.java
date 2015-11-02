package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplatesController extends BaseController<TemplatesRSDto> {

    @Inject
    private TemplatesService templatesService;

    @Override
    protected BaseDataService<TemplatesRSDto, TemplatesEntity> getResourceTypeService() {
        return templatesService;
    }
}
