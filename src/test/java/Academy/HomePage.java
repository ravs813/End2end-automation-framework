package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	private static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName,String Password,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		driver.manage().window().maximize();
		
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		log.info("Navigated to Login page");
		
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		lp.getLoginbutton().click();
		System.out.println(text);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	@DataProvider
	public Object[][] getData()
	{
		//rows stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0]="bc@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted user";
		
		data[1][0]="abc@qw.com";
		data[1][1]="125563456";
		data[1][2]="Non restricted user";
		
		return data;
		
	}
	
	
}
