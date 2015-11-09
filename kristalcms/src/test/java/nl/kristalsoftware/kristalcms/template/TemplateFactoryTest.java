package nl.kristalsoftware.kristalcms.template;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by sjoerdadema on 06/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemplateFactoryTest {

    @InjectMocks
    private TemplateFactory cut;

    @Mock
    private TemplateJcrData jcrData;

    @Before
    public void setUp() throws Exception {
        cut = new TemplateFactory();
        cut.jcrData = jcrData;
    }

    @Test
    public void testCreateEntity() throws Exception {
        when(jcrData.getId()).thenReturn("home");
        when(jcrData.getContent()).thenReturn("<body></body>");
        TemplateEntity templateEntity = cut.createEntity();
        assertNotNull(templateEntity);
        assertThat(templateEntity.getId(), is("home"));
        assertThat(templateEntity.getTemplateContent(), is("<body></body>"));
    }

    /*
    public void testCreateEntityList() throws Exception {
        List<String> templateEntityList = cut.createEntityPathList();
    }
    */
}