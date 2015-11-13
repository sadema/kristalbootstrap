package nl.kristalsoftware.kristalcms.customer.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;

/**
 * Created by sjoerdadema on 28/10/15.
 */
public class CustomerEntity extends BaseEntity {

    private String version;

    private String city;

    public CustomerEntity() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
