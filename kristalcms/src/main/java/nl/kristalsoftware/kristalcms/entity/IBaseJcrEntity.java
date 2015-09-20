package nl.kristalsoftware.kristalcms.entity;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface IBaseJcrEntity<T> {

    T getData(String path) throws PathNotFoundException, RepositoryException;
    String setData(String parentPath, T data) throws PathNotFoundException, ItemExistsException, RepositoryException;
    void removeData(String path) throws PathNotFoundException, RepositoryException;
/*
    void setDataFromJcrValues(Node node) throws PathNotFoundException, RepositoryException;
    void setJcrValuesFromData(Node node, T data) throws PathNotFoundException, RepositoryException;
*/
}
