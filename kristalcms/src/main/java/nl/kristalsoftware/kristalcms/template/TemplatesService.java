package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.annotation.Templates;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;
import nl.kristalsoftware.kristalcms.base.DataService;
import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;
import nl.kristalsoftware.kristalcms.customer.CustomerUriInfo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@RequestScoped
public class TemplatesService extends BaseDataService<TemplatesRSDto,TemplatesUriInfo> {

    @Inject
    private BaseMapper<TemplatesRSDto,TemplatesUriInfo> templatesMapper;

    @Override
    public BaseMapper<TemplatesRSDto,TemplatesUriInfo> getMapper() {
        return templatesMapper;
    }
}
