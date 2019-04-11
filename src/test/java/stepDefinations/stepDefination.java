package stepDefinations;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination extends base {
	@Given("^Intialize the browser with chrome$")
	public void intialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
		
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(arg1);
		
		driver.manage().window().maximize();

	}

	@Given("^Click on Login link in home page to land on Secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l= new LandingPage(driver);
		if (l.getPopUpSize()>0)
		{
			l.getPopUp().click();
		}
			
		l.getLogin().click();
	    
	}

	
	@When("^User enters (.+) and (.+) and logs in$")
	 public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginbutton().click();
	    }

		

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   portalHomePage ph = new portalHomePage(driver);
	   Assert.assertTrue(ph.getsearchBox().isDisplayed());
	}
	
	 @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	        driver.quit();
	    }

	
}