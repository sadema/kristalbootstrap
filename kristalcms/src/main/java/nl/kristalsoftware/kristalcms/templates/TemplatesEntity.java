package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.template.TemplateEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplatesEntity extends BaseEntity {

    private List<TemplateEntity> templateEntityList = new ArrayList<TemplateEntity>();

    public List<TemplateEntity> getTemplateEntityList() {
        return templateEntityList;
    }

    public void setTemplateEntityList(List<TemplateEntity> templateEntityList) {
        this.templateEntityList = templateEntityList;
    }
}
