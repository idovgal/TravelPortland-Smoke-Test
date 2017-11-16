package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanYouTripPage {WebDriver browserDriver;
WebDriverWait wait;

//fields	
private final By planYouTriplocator1=By.xpath("//*[@id='header-navigation']/nav/ul/li[3]/a");
private final By planYouTriplocator2=By.xpath("//li[@class='menu-item-plan active']/div/div[1]/a");
private final String pageTitle = "Plan a trip";	
private final String pageUrl = "https://www.travelportland.com/plan-your-trip/";

//Constructor
public PlanYouTripPage (WebDriver driver) {
browserDriver=driver;
wait=new WebDriverWait(driver, 40);	
}

//methods
public void openPage() throws InterruptedException{
	WebElement planYouTripLink1=wait.until(ExpectedConditions.elementToBeClickable(planYouTriplocator1));
	planYouTripLink1.click();	
	WebElement  planYouTripLink2=wait.until(ExpectedConditions.elementToBeClickable(planYouTriplocator2));
	planYouTripLink2.click();	Popup popup = new Popup(browserDriver); 
	   popup.close();	
	   if(isOpen()==false) throw new RuntimeException("Plan a trip page is not displayed");
	  }

public boolean isOpen() {			   
	boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(pageTitle));
	boolean isUrlCorrect=wait.until(ExpectedConditions.urlContains(pageUrl));
	return isTitleCorrect&&isUrlCorrect;	
	} 	
}
