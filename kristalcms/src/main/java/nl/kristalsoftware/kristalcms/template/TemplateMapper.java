package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 24/10/15.
 */
public class TemplateMapper implements BaseMapper<TemplateRSDto,TemplateUriInfo> {

    @Inject
    private TemplateJcrData templateJcrData;

    @Override
    public TemplateRSDto setFieldsInDto(Node node, TemplateUriInfo templateUriInfo) throws PathNotFoundException, RepositoryException {
        TemplateRSDto templateRSDto = new TemplateRSDto();
        templateRSDto.setCustomerId(templateUriInfo.getCustomerId());
        templateRSDto.setTemplateId(templateUriInfo.getTemplateId());
        Node htmlNode = node.getNode(TemplateService.HTMLNODENAME);
        Node contentNode = htmlNode.getNode(TemplateService.CONTENTNODENAME);
        templateRSDto.setTemplateContent(templateJcrData.getContent(contentNode));
        return templateRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, TemplateRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        templateJcrData.setContent(node, data.getTemplateContent());
    }
}
