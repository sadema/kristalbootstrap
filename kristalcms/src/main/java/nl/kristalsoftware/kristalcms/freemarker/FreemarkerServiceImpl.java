package nl.kristalsoftware.kristalcms.freemarker;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import nl.kristalsoftware.kristalcms.dto.TemplateRSDto;
import nl.kristalsoftware.kristalcms.entity.IBaseService;
import nl.kristalsoftware.kristalcms.main.KristalcmsFreemarker;

import javax.inject.Inject;
import java.io.*;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 13-10-15.
 */
public class FreemarkerServiceImpl implements FreemarkerService {

    @Inject
    private Logger logger;

    @Inject
    private KristalcmsFreemarker freemarker;

    @Inject
    private IBaseService<TemplateRSDto> templateService;

    @Override
    public String createHTMLPage(String templateName, Map content) throws IOException, TemplateException {
        Template template = freemarker.getConfiguration().getTemplate(templateName);
        StringWriter out = new StringWriter();
        template.process(content, out);
        return out.toString();
    }

    private String getTemplateContent(String templatePath) {
        String templateContent = null;
        try {
            TemplateRSDto templateRSDto = templateService.getData(templatePath);
            templateContent = templateRSDto.getTemplateContent();
        } catch (Exception e) {
            logger.info("Could not get the template content");
        }
        return templateContent;
    }


}
