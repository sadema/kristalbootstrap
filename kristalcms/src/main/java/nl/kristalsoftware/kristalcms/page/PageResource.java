package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.base.BaseController;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseResource;
import nl.kristalsoftware.kristalcms.freemarker.Card;
import nl.kristalsoftware.kristalcms.freemarker.Cards;
import nl.kristalsoftware.kristalcms.pages.PagesRSDto;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjoerdadema on 15-09-15.
 */
@Path("/cms")
@Produces("application/json,application/xml")
public class PageResource extends BaseResource<PageRSDto> {

    @AddLinks
    @LinkResource
    @GET
    @Path("{customerId}/pages/{pageId}")
    PageRSDto getPage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo) {
        return super.getResourceType(uriInfo.getPath());
    }

    @LinkResource(value = PagesRSDto.class)
    @POST
    @Path("{customerId}/pages")
    Response createPage(@PathParam("customerId") String customerId, CreatePageRSDto createPageRSDto, @Context UriInfo uriInfo) {
        Response response = null;
        /*
        String templateName = createPageRSDto.getTemplateName();
        Map content = this.getValue();
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
        */
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

    @DELETE
    @Path("{customerId}/pages/{pageId}")
    Response removePage(@PathParam("customerId") String customerId, @PathParam("pageId") String pageId, @Context UriInfo uriInfo) {
        return null; //super.removeResourceType();
    }

    @Override
    protected BaseController<PageRSDto> getController() {
        return null;
    }
}
