package nl.kristalsoftware.kristalcms.customers.jcr;

import nl.kristalsoftware.kristalcms.base.BaseJcrData;
import nl.kristalsoftware.kristalcms.base.NodeJcrData;
import nl.kristalsoftware.kristalcms.property.JcrList;

import javax.inject.Inject;

/**
 * Created by sjoerdadema on 19-09-15.
 */
public class CustomersJcrData extends NodeJcrData implements BaseJcrData {

    @Inject
    private JcrList nodeList;

    public JcrList getJcrList() {
        return nodeList;
    }

}
