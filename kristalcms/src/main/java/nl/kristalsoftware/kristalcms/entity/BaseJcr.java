package nl.kristalsoftware.kristalcms.entity;

/**
 * Created by sjoerdadema on 16-09-15.
 */
public interface BaseJcr<T> {

    T getData(String path);
}
