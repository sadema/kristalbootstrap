package nl.kristalsoftware.kristalcms.content;

import com.sun.xml.internal.rngom.parse.host.Base;
import nl.kristalsoftware.kristalcms.annotation.Content;
import nl.kristalsoftware.kristalcms.base.BaseDataService;
import nl.kristalsoftware.kristalcms.base.BaseMapper;

import javax.inject.Inject;
import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 19-10-15.
 */
public class ContentDataService extends BaseDataService<ContentRSDto,ContentUriInfo> {

    @Inject
    @Content
    private BaseMapper<ContentRSDto,ContentUriInfo> contentMapper;

    @Override
    public BaseMapper<ContentRSDto, ContentUriInfo> getMapper() {
        return contentMapper;
    }

}
