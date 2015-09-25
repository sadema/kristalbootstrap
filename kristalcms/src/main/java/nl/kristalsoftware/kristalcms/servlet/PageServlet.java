package nl.kristalsoftware.kristalcms.servlet;

import nl.kristalsoftware.kristalcms.jcrdata.PageJcrData;

import javax.inject.Inject;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 21-05-15.
 */
@WebServlet(name = "PageServlet", urlPatterns = {"/author/cms/*"} )
public class PageServlet extends HttpServlet {

    @Inject
    private Logger logger;

    @Inject
    private PageJcrData pageJcrData;

    @Inject
    private Session session;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        String nodePath = this.removeFromUri(uri, request.getContextPath() + "/author");
        try {
            String content = pageJcrData.getContent(session.getNode(nodePath));
            out.append(content);
        } catch (PathNotFoundException e) {
            logger.info("Nodepath " + nodePath + " not found!");
            response.setStatus(Response.Status.NOT_FOUND.getStatusCode());
        } catch (RepositoryException e) {
            throw new ServletException(e);
        }
    }

    private String removeFromUri(String uri, String s) {
        return uri.replace(s, "");
    }
}
