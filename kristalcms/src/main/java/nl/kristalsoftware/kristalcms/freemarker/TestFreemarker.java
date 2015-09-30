package nl.kristalsoftware.kristalcms.freemarker;

import freemarker.cache.TemplateLoader;
import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.inject.Inject;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 25-09-15.
 */
public class TestFreemarker {

    private static Logger logger = Logger.getLogger("TestFreemarker");

    private Configuration cfg = null;

    public TestFreemarker() {}

    public void setConfiguration() {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setTemplateLoader(new URLTemplateLoader() {
            @Override
            protected URL getURL(String s) {
                String urlSpec = "http://localhost:8080/kristalcms/resources/cms/prima/templates/" + s;
                logger.info(urlSpec);
                URL url = null;
                try {
                    url = new URL(urlSpec);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return url;
            }
        });
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public Configuration getConfiguration() {
        return cfg;
    }

    public static void main(String[] args) throws Exception {
        TestFreemarker testFreemarker = new TestFreemarker();
        testFreemarker.setConfiguration();
        Map cms = testFreemarker.createDataModel();
        Template template = testFreemarker.cfg.getTemplate("main");
        Writer out = new OutputStreamWriter(System.out);
        template.process(cms, out);
    }

    private Map createDataModel() {
        Map cms = new HashMap();
        Map customer = new HashMap();
        cms.put("customer", customer);
        customer.put("id", "prima");
        customer.put("versie", "1.0");
        customer.put("city", "Nunspeet");
        return cms;
    }
}
