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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 25-09-15.
 */
public class TestFreemarker {

    private static Logger logger = Logger.getLogger("TestFreemarker");

    private Configuration cfg = null;

    private Cards cards;

    public TestFreemarker() {}

    public void setConfiguration() {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
/*
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
*/
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
        //Template template = testFreemarker.cfg.getTemplate("main");
        Template template = testFreemarker.cfg.getTemplate("bstr.ftl");
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
        Card card1 = new Card();
        card1.setTitle("Menukaart");
        card1.setText("Restaurant PRIMA uit Nunspeet stelt al haar gerechten met de grootste zorg samen uit eerlijke, verse en lokale producten. Bij PRIMA hanteren wij het uitgangspunt: weet wat je eet. Gerechten zijn daarom ...");
        Card card2 = new Card();
        card2.setTitle("Catering en events");
        card2.setText("Wilt u een leuk feest of proeverij organiseren? Of wil u misschien gezellig uw verjaardag vieren met familie en vrienden? ...");
        List<Card> cardList = Arrays.asList(card1, card2);
        int numOfCardsOnRow = 3;
        int numOfColls = (cardList.size()%numOfCardsOnRow) * 4;
        Cards cards = new Cards();
        cards.setCardList(cardList);
        Map content = new HashMap();
        cms.put("content", content);
        Map cardContent = new HashMap();
        content.put("cardContent", cards);
        content.put("numOfColls", numOfColls);
        return cms;
    }
}
