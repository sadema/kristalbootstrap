package nl.kristalsoftware.kristalcms.template.jcr;

import nl.kristalsoftware.kristalcms.main.BaseTest;
import nl.kristalsoftware.kristalcms.property.JcrContentNode;
import nl.kristalsoftware.kristalcms.property.TextFileJcrContentNode;
import nl.kristalsoftware.kristalcms.template.jcr.TemplateJcrData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jcr.Node;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by sjoerdadema on 08/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemplateJcrDataTest extends BaseTest {

    private static String ANY_CONTENT = "any template content";

    private TemplateJcrData cut;

    @Mock
    private JcrContentNode<String> content = new TextFileJcrContentNode();

    private Node node;

    public TemplateJcrDataTest() {
        super("kristalcmstest.xml");
    }

    @Before
    public void setUp() throws Exception {
        super.before();
        cut = new TemplateJcrData();
        cut.content = content;
        assertNotNull(session);
    }

    @Test
    public void testGetContent() throws Exception {
        node = session.getNode("/cms/prima/templates/main");
        cut.setNode(node);
        cut.getContent();
        verify(content).getValue(node);
    }

    @Test
    public void testSetContent() throws Exception {
        node = session.getNode("/cms/prima/templates");
        Node newNode = node.addNode("new_id", "nt:file");
        cut.setNode(newNode);
        cut.setContent(ANY_CONTENT);
        verify(content).setValue(newNode, ANY_CONTENT);
    }

    @Test
    public void testGetNode() throws Exception {
        node = session.getNode("/cms/prima/templates/main");
        cut.setNode(node);
        assertThat(cut.getNode(), is(node));
    }

    @Test
    public void testGetId() throws Exception {
        node = session.getNode("/cms/prima/templates/main");
        cut.setNode(node);
        String id = cut.getId();
        assertThat(id, is("main"));
    }
}