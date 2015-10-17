package nl.kristalsoftware.kristalcms.page;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sjoerdadema on 10-07-15.
 */
//@NoJackson
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="pages")
public class PageCollectionData {

    private String nodename = "pages";

    @XmlElement(name="page")
    private Collection<PageRSDto> pageCollection = new ArrayList<PageRSDto>();

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public Collection<PageRSDto> getPageCollection() {
        return pageCollection;
    }

    public void setPageCollection(Collection<PageRSDto> pageCollection) {
        this.pageCollection = pageCollection;
    }
}
