package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDAO;
import nl.kristalsoftware.kristalcms.main.BaseTest;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntity;
import nl.kristalsoftware.kristalcms.template.entity.TemplateEntityFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by sjoerdadema on 12/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemplateDAOTest extends BaseTest {

    private BaseDAO<TemplateEntity> cut;

    @Mock
    private TemplateEntityFactory templateEntityFactory;

    public TemplateDAOTest() {
        super("kristalcmstest.xml");
    }

    @Before
    public void setUp() throws Exception {
        super.before();
        //templateEntityFactory = new TemplateEntityFactory(session, new TemplateJcrData());
        cut = new TemplateDAO(templateEntityFactory);
    }

    @Test
    public void testGetEntity() throws Exception {
        when(templateEntityFactory.createEntity("/cms/prima/templates/main")).thenReturn(new TemplateEntity());
        TemplateEntity entity = cut.getEntity("/cms/prima/templates/main");
        assertNotNull(entity);
    }
}