package nl.kristalsoftware.kristalcms.content;

import nl.kristalsoftware.kristalcms.customer.CustomerRSDto;
import nl.kristalsoftware.kristalcms.page.PageRSDto;
import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 10-07-15.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="content")
public class ContentRSDto {

    @ParentResource
    private PageRSDto pageRSDto = new PageRSDto();

    private String contentId = "content";

    @XmlElement(name="card")
    private List<CardRSDto> cardList = new ArrayList<CardRSDto>();

    @XmlElementRef
    private RESTServiceDiscovery rest;

    public ContentRSDto() {}

    public void setPageId(String pageId) {
        pageRSDto.setPageId(pageId);
        for (CardRSDto card : cardList) {
            card.setPageId(pageId);
        }
    }

    public String getPagesId() {
        return pageRSDto.getPageId();
    }

    public List<CardRSDto> getCardList() {
        return cardList;
    }

    public void setCardList(List<CardRSDto> cardList) {
        this.cardList = cardList;
    }

    public PageRSDto getPageRSDto() {
        return pageRSDto;
    }
}
