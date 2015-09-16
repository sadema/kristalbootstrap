package nl.kristalsoftware.kristalcms.property;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class StringJcrProperty implements JcrProperty<String> {

    @Inject
    private Logger logger;

    @Override
    public String getData(Node node, String propertyName) {
        String value = "";
        try {
            value = node.getProperty(propertyName).getString();
        } catch(PathNotFoundException e) {
            logger.info("Property version does not exist");
        } catch (ValueFormatException e) {
            e.printStackTrace();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return value;
    }
}
