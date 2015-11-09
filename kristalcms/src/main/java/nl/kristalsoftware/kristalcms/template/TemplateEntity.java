package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseEntity;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class TemplateEntity extends BaseEntity {

    private String templateContent;

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }
}
