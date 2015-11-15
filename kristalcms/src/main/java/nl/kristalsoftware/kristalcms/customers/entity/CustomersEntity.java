package nl.kristalsoftware.kristalcms.customers.entity;

import nl.kristalsoftware.kristalcms.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 01/11/15.
 */
public class CustomersEntity extends BaseEntity {

    private List<String> customerEntityPathList = new ArrayList<String>();

    public List<String> getCustomerEntityList() {
        return customerEntityPathList;
    }

    public void setCustomerEntityList(List<String> customerEntityPathList) {
        this.customerEntityPathList = customerEntityPathList;
    }
}
