package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacesToVisitPage {
	WebDriver browserDriver;
	WebDriverWait wait;

	//fields	
	private final By placesToVisit1locator=By.xpath("//li[@class='menu-item-places']/a");
	private final By placesToVisit2Locator=By.xpath("//li[@class='menu-item-places active']/div/div[1]/a[1]");
	private final String pageTitle = "Places to Visit";	
	private final String pageUrl = "https://www.travelportland.com/places-visit/";
	
	//Constructor
	public PlacesToVisitPage (WebDriver driver) {
	browserDriver=driver;
	wait=new WebDriverWait(driver, 40);	
	}

	//methods
	public void openPage() throws InterruptedException{
		WebElement placesToVisitLink1=wait.until(ExpectedConditions.elementToBeClickable(placesToVisit1locator));
		placesToVisitLink1.click();	
		WebElement  placesToVisitLink2=wait.until(ExpectedConditions.elementToBeClickable(placesToVisit2Locator));
		placesToVisitLink2.click();	
		Popup popup = new Popup(browserDriver); 
		   popup.close();
		   if(isOpen()==false) throw new RuntimeException("Places to Visit page is not displayed");
		  }
	
	public boolean isOpen() {			   
		boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(pageTitle));
		boolean isUrlCorrect=wait.until(ExpectedConditions.urlContains(pageUrl));
		return isTitleCorrect&&isUrlCorrect;	
	} 	
}
