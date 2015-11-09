package nl.kristalsoftware.kristalcms.main;

import org.modeshape.common.collection.Problems;
import org.modeshape.jcr.ConfigurationException;
import org.modeshape.jcr.ModeShapeEngine;
import org.modeshape.jcr.NoSuchRepositoryException;
import org.modeshape.jcr.RepositoryConfiguration;

import javax.jcr.ImportUUIDBehavior;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.io.*;
import java.net.URL;
import java.util.logging.Logger;

public class EmbeddedRepository {

	private ModeShapeEngine engine = null;
	private RepositoryConfiguration config = null;
	private Logger logger = Logger.getLogger("EmbeddedRepository.class");
	
	public EmbeddedRepository() {
		engine = new ModeShapeEngine();
	}
	
	private void config() throws Exception {
		URL url = EmbeddedRepository.class.getClassLoader().getResource("kristalcms-repository-config.json");
		logger.info("Path: " + url.getPath());
		config = RepositoryConfiguration.read(url);
		Problems problems = config.validate();
		if (problems.hasErrors()) {
			throw new Exception();
		}

	}
	
	public boolean startEngine() {
		boolean retVal = false;
		try {
			engine.start();
			this.config();
			retVal = true;
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		return retVal;
	}
	
	public void stopEngine() {
		engine.shutdown();
	}
	
	public Repository deploy() {
		Repository repository = null;
		try {
			repository = engine.deploy(config);
		} catch (ConfigurationException e) {
			logger.severe(e.getMessage());
		} catch (RepositoryException e) {
			logger.severe(e.getMessage());
		}
		return repository;
	}
	
	public String getRepositoryName() {
		return config.getName();
	}
	
	public Repository getRepository(String reponame) throws NoSuchRepositoryException {
		return engine.getRepository(reponame);
	}
	
	public void importXML(Session session, String xmlFileName) {
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream(xmlFileName);
		if (is != null) {
			try {
				session.importXML("/", is, ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
				session.save();
				logger.info(xmlFileName + " import done!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println(xmlFileName + " not found.");
		}
	}
	
	public void exportDocumentXML(Session session, String baseNodePath, String filePath) {
		try {
			session.exportDocumentView(baseNodePath, new FileOutputStream(new File(filePath)), false, false);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportSystemXML(Session session, String baseNodePath, String filePath) {
		try {
			session.exportSystemView(baseNodePath, new FileOutputStream(new File(filePath)), false, false);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
