package nl.kristalsoftware.kristalcms.property;

import nl.kristalsoftware.kristalcms.annotation.TextFile;

import javax.inject.Inject;
import javax.jcr.*;
import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@TextFile
public class TextFileJcrProperty implements JcrProperty<String> {

    @Inject
    Logger logger;

    @Override
    public String getPropertyValue(Node node, String propertyName) throws RepositoryException {
        String value = null;
        try {
            Node contentNode = node.getNode("jcr:content");
            Property dataProperty = contentNode.getProperty("jcr:data");
            value = dataProperty.getString();
        } catch (PathNotFoundException e) {
            logger.info("Property " + propertyName + " does not exist");
        }
        return value;
    }

    @Override
    public void setPropertyValue(Node node, String propertyName, String content) throws RepositoryException {
        if (node != null) {
            ByteArrayInputStream is = new ByteArrayInputStream(content.getBytes());
            Binary binaryData = node.getSession().getValueFactory().createBinary(is);
            Node contentNode = node.addNode("jcr:content", "nt:resource");
            contentNode.setProperty("jcr:mimeType", "text/html");
            contentNode.setProperty("jcr:encoding", "UTF-8");
            contentNode.setProperty("jcr:data", binaryData);
        }
    }
}
