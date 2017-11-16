package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThingsToDoPage {
	WebDriver browserDriver;
	WebDriverWait wait;

	//fields	
	private final By thingsToDoLink1locator=By.xpath("//li[@class='menu-item-things-to-do']/a");
	private final By thingsToDoLink2Locator=By.xpath("//li[@class='menu-item-things-to-do active']/div/div[1]/a[1]");
	private final String pageTitle = "Things to Do";	
	private final String pageUrl = "https://www.travelportland.com/things-to-do/";
	
	//Constructor
	public ThingsToDoPage (WebDriver driver) {
	browserDriver=driver;
	wait=new WebDriverWait(driver, 40);	
	}

	//methods
	public void openPage() throws InterruptedException{
		WebElement toDoLink1=wait.until(ExpectedConditions.elementToBeClickable(thingsToDoLink1locator));
		toDoLink1.click();	
		WebElement toDoLink2=wait.until(ExpectedConditions.elementToBeClickable(thingsToDoLink2Locator));
		toDoLink2.click();	
		   if(isOpen()==false) throw new RuntimeException("Things To Do page is not displayed");
		  }
	
	public boolean isOpen() {			   
		boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(pageTitle));
		boolean isUrlCorrect=wait.until(ExpectedConditions.urlContains(pageUrl));
		return isTitleCorrect&&isUrlCorrect;	
	} 	
}
