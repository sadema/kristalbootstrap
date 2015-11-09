package nl.kristalsoftware.kristalcms.main;

import org.junit.After;
import org.junit.Before;
import org.modeshape.jcr.NoSuchRepositoryException;

import javax.jcr.*;
import java.util.logging.Logger;

public class BaseTest {

	private final String importXMLName;
	private final EmbeddedRepository embeddedRepository;
	private Repository repository = null;
	protected Session session = null;

	private Logger logger = Logger.getLogger("BaseTest.class");

	protected BaseTest(String importXMLName) {
		this.importXMLName = importXMLName;
		embeddedRepository = new EmbeddedRepository();	
	}
	
	//@Before
	public void before() throws LoginException, NoSuchWorkspaceException, RepositoryException {
		if (embeddedRepository.startEngine()) {
			repository = embeddedRepository.deploy();
			if (repository != null) {
				session = repository.login("default");
				String repositoryName = embeddedRepository.getRepositoryName();
				logger.info(repositoryName);
				embeddedRepository.importXML(session, importXMLName);
			}
			else {
				throw new RepositoryException();
			}
		}
	}
	
	@After
	public void after() throws NoSuchRepositoryException {
		embeddedRepository.stopEngine();
	}
	
}
