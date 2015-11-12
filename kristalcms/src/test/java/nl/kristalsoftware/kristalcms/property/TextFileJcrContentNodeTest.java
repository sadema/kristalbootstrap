package nl.kristalsoftware.kristalcms.property;

import nl.kristalsoftware.kristalcms.main.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jcr.Node;

import static org.junit.Assert.assertNotNull;

/**
 * Created by sjoerdadema on 10/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TextFileJcrContentNodeTest extends BaseTest {

    private static final String NODE_TEMPLATE_PATH = "/cms/prima/templates/main";
    private static final String CONTENT = "<body></body>";

    private TextFileJcrContentNode cut;

    private Node node;

    public TextFileJcrContentNodeTest() {
        super("kristalcmstest.xml");
    }

    @Before
    public void setUp() throws Exception {
        super.before();
        cut = new TextFileJcrContentNode();
        node = session.getNode(NODE_TEMPLATE_PATH);
    }

    @Test
    public void testGetValue() throws Exception {
        String value = cut.getValue(node);
        assertNotNull(value);
    }

    @Test
    public void testSetValue() throws Exception {
        Node templatesNode = node.getParent();
        Node newNode = templatesNode.addNode("new_template", "nt:file");
        cut.setValue(newNode, CONTENT);
    }
}