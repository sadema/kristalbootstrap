package nl.kristalsoftware.kristalcms.freemarker;

import com.ctc.wstx.io.CharsetNames;
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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
        Template template = freemarker.getConfiguration().getTemplate("bstr.ftl");
//        Template template = freemarker.getConfiguration().getTemplate(templateName);
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
