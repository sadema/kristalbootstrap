package nl.kristalsoftware.kristalcms.data;

import javax.xml.bind.annotation.*;

/**
 * Created by sjoerdadema on 10-07-15.
 */
//@NoJackson
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="page")
public class PageData {

    @XmlAttribute(name="id")
    private String nodename;

    @XmlElement(name="content")
    private String pageContent;

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}
