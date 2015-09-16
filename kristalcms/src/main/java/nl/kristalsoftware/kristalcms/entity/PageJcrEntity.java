package nl.kristalsoftware.kristalcms.entity;

import nl.kristalsoftware.kristalcms.annotation.TextFile;
import nl.kristalsoftware.kristalcms.data.PageData;
import nl.kristalsoftware.kristalcms.property.JcrProperty;

import javax.inject.Inject;
import javax.jcr.*;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public class PageJcrEntity extends BaseJcrEntity implements IBaseJcrEntity<PageData> {

    @Inject
    private Session session;

    @Inject
    private PageData pageData;

    @Inject
    @TextFile
    private JcrProperty<String> content;

    @Override
    public PageData getData(String path) throws PathNotFoundException, RepositoryException {
        Node node = session.getNode(path);
        this.setDataFromJcrValues(node);
        return pageData;
    }

    @Override
    public String setData(String parentPath, PageData entity) throws PathNotFoundException, ItemExistsException, RepositoryException {
        String newPath = null;
        if (!nodeExists(session, buildPath(parentPath, entity.getNodename()))) {

        }
        return newPath;
    }

    @Override
    public void setDataFromJcrValues(Node node) throws PathNotFoundException, RepositoryException  {
        pageData.setNodename(node.getName());
        pageData.setPageContent(content.getPropertyValue(node, "content"));
    }

    @Override
    public void setJcrValuesFromData(Node node) throws PathNotFoundException, RepositoryException {

    }
}
