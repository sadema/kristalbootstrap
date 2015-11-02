package nl.kristalsoftware.kristalcms.base;

import nl.kristalsoftware.kristalcms.main.CMSDataException;

import javax.jcr.PathNotFoundException;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public abstract class BaseController<T> {

    public T getResourceType(String path) throws PathNotFoundException, CMSDataException {
        return getResourceTypeService().getData(path);
    }

    abstract protected <E extends BaseEntity> BaseDataService<T,E> getResourceTypeService();

}
