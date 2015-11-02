package nl.kristalsoftware.kristalcms.base;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class BaseEntity {

    private String path;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
