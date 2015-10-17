package nl.kristalsoftware.kristalcms.main;

import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 12-10-15.
 */
@ApplicationScoped
public class KristalcmsFreemarkerImpl implements KristalcmsFreemarker {

    @Inject
    private Logger logger;

    private Configuration cfg = null;

    public KristalcmsFreemarkerImpl() {}

    @PostConstruct
    public void init() {
        logger.info("init postconstruct in KristalcmsFreemarkerImpl");
        cfg = new Configuration(Configuration.VERSION_2_3_23);
//        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
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

}
