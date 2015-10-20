package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.page.PageRSDto;
import org.jboss.resteasy.links.ParentResource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjoerdadema on 18-10-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="card")
public class CardRSDto {

    @ParentResource
    private PageRSDto pageRSDto = new PageRSDto();

    public CardRSDto() {}

    public void setPageId(String pageId) {
        pageRSDto.setPageId(pageId);
    }

    public void setCustomerId(String customerId) {
        pageRSDto.setCustomerId(customerId);
    }

}
