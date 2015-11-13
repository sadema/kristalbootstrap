package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.entity.BaseItemEntityFactory;
import nl.kristalsoftware.kristalcms.base.entity.BaseRootItemEntityFactory;
import nl.kristalsoftware.kristalcms.main.BaseTest;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntity;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntityFactory;
import nl.kristalsoftware.kristalcms.template.jcr.TemplateJcrData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by sjoerdadema on 06/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemplateEntityFactoryTest extends BaseTest{

    //@InjectMocks
    private BaseItemEntityFactory<TemplateEntity> cut;

    @Mock
    private TemplateJcrData jcrData;

    public TemplateEntityFactoryTest() {
        super("kristalcmstest.xml");
    }

    @Before
    public void setUp() throws Exception {
        super.before();
        cut = new TemplateEntityFactory(session, jcrData);
        //cut.jcrData = jcrData;
    }

    @Test
    public void testCreateEntity() throws Exception {
        when(jcrData.getId()).thenReturn("home");
        when(jcrData.getContent()).thenReturn("<body></body>");
        TemplateEntity templateEntity = cut.createEntity("/cms/prima/templates/main");
        assertNotNull(templateEntity);
        assertThat(templateEntity.getId(), is("home"));
        assertThat(templateEntity.getTemplateContent(), is("<body></body>"));
        //TODO Sjoerd: verify(jcrData).setNode(node)
    }

    public void testCreateEntityPathList() throws Exception {
        List<String> templateEntityList = cut.createEntityPathList("/cms/prima/templates");
    }

}