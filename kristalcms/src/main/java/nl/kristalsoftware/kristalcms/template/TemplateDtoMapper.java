package nl.kristalsoftware.kristalcms.template;

import nl.kristalsoftware.kristalcms.base.BaseDtoMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 24/10/15.
 */
public class TemplateDtoMapper { //implements BaseDtoMapper<TemplateRSDto,TemplateUriInfo> {

    /*
    @Inject
    private TemplateJcrData templateJcrData;

    @Override
    public TemplateRSDto setFieldsInDto(Node node, TemplateUriInfo templateUriInfo) throws PathNotFoundException, RepositoryException {
        TemplateRSDto templateRSDto = new TemplateRSDto();
        templateRSDto.setCustomerId(templateUriInfo.getCustomerId());
        templateRSDto.setTemplateId(templateUriInfo.getTemplateId());
        Node htmlNode = node.getNode(TemplateService.HTMLNODENAME);
        Node contentNode = htmlNode.getNode(TemplateService.CONTENTNODENAME);
        templateRSDto.setTemplateContent(templateJcrData.getValue(contentNode));
        return templateRSDto;
    }

    @Override
    public void setFieldsInRepository(Node node, TemplateRSDto data) throws PathNotFoundException, ItemExistsException, RepositoryException {
        Node htmlNode = node.getNode(TemplateService.HTMLNODENAME);
        Node contentNode = htmlNode.getNode(TemplateService.CONTENTNODENAME);
        templateJcrData.setValue(contentNode, data.getTemplateContent());
    }
    */
}
