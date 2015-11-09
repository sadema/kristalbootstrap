package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.main.BaseTest;
import nl.kristalsoftware.kristalcms.property.JcrProperty;
import nl.kristalsoftware.kristalcms.property.TextFileJcrProperty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by sjoerdadema on 08/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemplateJcrDataTest extends BaseTest {

    private static String ANY_CONTENT = "any template content";

    private TemplateJcrData cut;

    @Mock
    private JcrProperty<String> content;

    private Node node;

    public TemplateJcrDataTest() {
        super("kristalcmstest.xml");
    }

    @Before
    public void setUp() throws Exception {
        super.before();
        cut = new TemplateJcrData();
        content = new TextFileJcrProperty();
        cut.content = content;
        try {
            this.node = session.getNode("/cms/prima/templates/home");
        } catch (RepositoryException e) {
        }
        assertNotNull(session);
    }

    @Test
    public void testSessionExists() {
        assertNotNull(session);
    }

    @Test
    public void testGetContent() throws Exception {
        cut.getContent();
        verify(content).getPropertyValue(node, "content");
    }

    @Test
    public void testSetContent() throws Exception {
        cut.setContent(ANY_CONTENT);
        verify(content).setPropertyValue(node, "content", anyString());
    }

    @Test
    public void testGetNode() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {

    }
}