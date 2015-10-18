package nl.kristalsoftware.kristalcms.freemarker;

import freemarker.template.TemplateException;

import javax.jcr.RepositoryException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sjoerdadema on 13-10-15.
 */
public interface FreemarkerService {

    String createHTMLPage(String templateName, Map content) throws IOException, TemplateException, RepositoryException;

}
