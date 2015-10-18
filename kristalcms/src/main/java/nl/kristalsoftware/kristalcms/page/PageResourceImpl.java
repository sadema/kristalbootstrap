package nl.kristalsoftware.kristalcms.page;

import freemarker.template.TemplateException;
import nl.kristalsoftware.kristalcms.base.IBaseService;
import nl.kristalsoftware.kristalcms.freemarker.Card;
import nl.kristalsoftware.kristalcms.freemarker.Cards;
import nl.kristalsoftware.kristalcms.freemarker.FreemarkerService;
import nl.kristalsoftware.kristalcms.main.JcrUtils;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 15-09-15.
 */
public class PageResourceImpl implements IPageResource {

    @Inject
    private Logger logger;

    @Inject
    private IBaseService<PagesRSDto> pagesService;

    @Inject
    private IBaseService<PageRSDto> pageService;

    @Inject
    private FreemarkerService freemarkerService;

    @Inject
    private JcrUtils jcrUtils;

    @Override
    public PagesRSDto getPages(String customerId, @Context UriInfo uriInfo) {
        PagesRSDto pagesRSDto = null;
        try {
            pagesRSDto = pagesService.getData(uriInfo.getPath());
            pagesRSDto.setCustomer(customerId);
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return pagesRSDto;
    }

    @Override
    public PageRSDto getPage(String customerId, String pageId, @Context UriInfo uriInfo) {
        PageRSDto pageRSDto = null;
        try {
            pageRSDto = pageService.getData(uriInfo.getPath());
            pageRSDto.setCustomerId(customerId);
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException((Response.Status.INTERNAL_SERVER_ERROR));
        }
        return pageRSDto;
    }

    @Override
    public Response createPage(String customerId, CreatePageRSDto createPageRSDto, @Context UriInfo uriInfo) {
        Response response = null;
        String templateName = createPageRSDto.getTemplateName();
        Map content = this.getContent();
        try {
            String htmlPage = freemarkerService.createHTMLPage(templateName, content);
            PageRSDto pageRSDto = new PageRSDto(createPageRSDto.getPageId());
            pageRSDto.setPageContent(htmlPage);
            pageRSDto.setCustomerId(customerId);
            String newPath = pageService.createData(uriInfo.getPath(), pageRSDto);
            response = Response.created(URI.create(newPath)).build();
        } catch (ItemExistsException e) {
            throw new WebApplicationException(422);     // unprocessable entity
        } catch (IOException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        } catch (TemplateException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    private Map getContent() {
        Card card1 = new Card();
        card1.setTitle("Menukaart");
        card1.setText("Restaurant PRIMA uit Nunspeet stelt al haar gerechten met de grootste zorg samen uit eerlijke, verse en lokale producten. Bij PRIMA hanteren wij het uitgangspunt: weet wat je eet. Gerechten zijn daarom ...");
        Card card2 = new Card();
        card2.setTitle("Catering en events");
        card2.setText("Wilt u een leuk feest of proeverij organiseren? Of wil u misschien gezellig uw verjaardag vieren met familie en vrienden? ...");
        List<Card> cardList = Arrays.asList(card1, card2);
        int numOfCardsOnRow = 3;
        int numOfColls = (cardList.size()%numOfCardsOnRow) * 4;
        Cards cards = new Cards();
        cards.setCardList(cardList);
        Map content = new HashMap();
        Map cardInfo = new HashMap();
        content.put("cardInfo", cardInfo);
        cardInfo.put("cardContent", cards);
        cardInfo.put("numOfColls", numOfColls);
        return content;
    }

    @Override
    public Response removePage(String customerId, String pageId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            pageService.removeData(uriInfo.getPath());
            response = Response.noContent().build();
        } catch (PathNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (RepositoryException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
