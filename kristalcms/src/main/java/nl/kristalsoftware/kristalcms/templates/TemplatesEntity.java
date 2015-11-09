package nl.kristalsoftware.kristalcms.templates;

import nl.kristalsoftware.kristalcms.base.BaseEntity;
import nl.kristalsoftware.kristalcms.template.TemplateEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplatesEntity extends BaseEntity {

    private List<String> templateEntityPathList = new ArrayList<String>();

    public List<String> getTemplateEntityList() {
        return templateEntityPathList;
    }

    public void setTemplateEntityList(List<String> templateEntityPathList) {
        this.templateEntityPathList = templateEntityPathList;
    }
}
