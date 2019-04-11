package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	public WebDriver driver;
	By searchBox=By.name("query");
	
	public portalHomePage(WebDriver driver) {
	
		this.driver=driver;
	}


	public WebElement getsearchBox()
	{
		return driver.findElement(searchBox);
	}
	

	
}

