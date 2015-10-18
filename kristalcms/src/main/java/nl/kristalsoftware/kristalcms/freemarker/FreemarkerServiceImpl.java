package nl.kristalsoftware.kristalcms.freemarker;

import com.sun.mail.iap.ByteArray;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import nl.kristalsoftware.kristalcms.template.TemplateRSDto;
import nl.kristalsoftware.kristalcms.base.IBaseService;
import nl.kristalsoftware.kristalcms.main.KristalcmsFreemarker;
import org.jboss.marshalling.ByteOutputStream;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import java.io.*;
import java.nio.charset.Charset;
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

/*
    @Override
    public String createHTMLPage(String templateName, Map content) throws IOException, TemplateException {
//        Template template = freemarker.getConfiguration().getTemplate("bstr.ftl");
        Template template = freemarker.getConfiguration().getTemplate(templateName);
        template.setOutputEncoding("UTF-8");
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
//        template.process(content, writer);

        CharArrayWriter out = new CharArrayWriter();
        template.process(content, out);
        String htmlpage = out.toString();
//        System.out.print(out.toCharArray());
//        return out.toString();
//        String htmlpage = os.toString("UTF-8");
        System.out.print(htmlpage);
        return htmlpage;
    }
*/

    @Override
    public String createHTMLPage(String templateName, Map content) throws IOException, TemplateException {
        String pageHtml = "";
        logger.info(Charset.defaultCharset().toString());
        try {
            TemplateRSDto dto = templateService.getData("/cms/prima/templates/main");
            String templateHtml = dto.getTemplateContent();
            byte[] ba = templateHtml.getBytes("UTF-8");
            ByteArrayInputStream is = new ByteArrayInputStream(ba);
            logger.info(new String(ba));
            Template template = new Template(templateName, new InputStreamReader(is), null);
            //Template template = freemarker.getConfiguration().getTemplate("bstr.ftl");
            template.setOutputEncoding("UTF-8");
            //CharArrayWriter out = new CharArrayWriter();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
            logger.info(writer.getEncoding());
            template.process(content, writer);
            pageHtml = os.toString();
            logger.info(pageHtml);
        } catch (RepositoryException e) {
            logger.severe(e.getMessage());
        }
        return pageHtml;
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
