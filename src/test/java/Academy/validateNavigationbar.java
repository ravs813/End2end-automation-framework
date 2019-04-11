package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavigationbar extends base {
	private static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Navigated to Home page");
	}
	
	@Test()
	public void validateNavigation()
	{
		LandingPage l= new LandingPage(driver);
	
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.getNavigationbar().isDisplayed());
		
		log.info("Navigation bar is displayed");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
