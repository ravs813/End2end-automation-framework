package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//By formationstData=By.className("kx-legend");
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By navigationbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By popup =By.xpath("//button[contains(text(),'NO THANKS')]");
	//Constructor
	public LandingPage(WebDriver driver) {
	
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationbar()
	{
		return driver.findElement(navigationbar);
	}
	
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
}
