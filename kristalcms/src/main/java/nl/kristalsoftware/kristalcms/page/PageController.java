package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.freemarker.PageEventData;
import nl.kristalsoftware.kristalcms.template.TemplateService;
import nl.kristalsoftware.kristalcms.template.TemplateUriInfo;

import javax.enterprise.event.Observes;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sjoerdadema on 26/10/15.
 */
public class PageController {

    private TemplateService templateService;

    public void createHtmlPage(@Observes PageEventData pageEventData) {
        // get the templatedata
        // get the templatecontent
        /*
                String pageHtml = "";
        logger.info(Charset.defaultCharset().toString());
        TemplateRSDto dto = templateService.getData("/cms/prima/templates/main");
        String templateHtml = dto.getTemplateContent();
        if (templateHtml != null) {
            byte[] templateHtmlAsBytes = templateHtml.getBytes("UTF-8");
            ByteArrayInputStream is = new ByteArrayInputStream(templateHtmlAsBytes);
            Template template = new Template(templateName, new InputStreamReader(is), freemarker.getConfiguration());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
            template.process(content, writer);
            pageHtml = os.toString();
            logger.info(pageHtml);
        }
        else {
            throw new RepositoryException();
        }
        return pageHtml;

         */
    }

    /*
        private String getTemplateContent(String templatePath) {
        String templateContent = null;
        try {
            TemplateRSDto templateRSDto = templateService.getData(templatePath);
            templateContent = templateRSDto.getTemplateContent();
        } catch (RepositoryException e) {
            logger.info("Could not get the template content");
        }
        return templateContent;
    }
     */
}
