package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplateController extends BaseController<TemplateRSDto> {

    @Inject
    private TemplateService templateService;

    @Override
    protected <E extends BaseEntity> BaseDataService<TemplateRSDto, E> getResourceTypeService() {
        return null;
    }
}