package nl.kristalsoftware.kristalcms.customers.rest;

import nl.kristalsoftware.kristalcms.customer.rest.CustomerLinkRSDto;
import nl.kristalsoftware.kristalcms.customer.rest.CustomerRSDto;
import org.jboss.resteasy.links.ResourceFacade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjoerdadema on 13/11/15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="customers")
public class CustomersRSDto implements ResourceFacade<CustomerRSDto> {

    @XmlElement(name = "customer")
    private List<CustomerRSDto> customerList = new ArrayList<CustomerRSDto>();

    public CustomersRSDto() {
    }

    @Override
    public Class<CustomerRSDto> facadeFor() {
        return CustomerRSDto.class;
    }

    @Override
    public Map<String, ?> pathParameters() {
        HashMap<String, String> parameters = new HashMap<String, String>();
        //parameters.put("customerId", "prima");
        return parameters;
    }

    public void setCustomerList(List<CustomerLinkRSDto> customerLinkList) {
        for (CustomerLinkRSDto dto : customerLinkList) {
            CustomerRSDto customerRSDto = new CustomerRSDto();
            customerRSDto.setCustomerId(dto.getCustomerId());
            customerList.add(customerRSDto);
        }
    }
}
