package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver browserDriver;
	WebDriverWait wait;
	
	//fields
	private final String HomePageTitle  ="Visit Portland, Oregon - Travel Portland";
	private final String homePageUrl    ="https://www.travelportland.com/";
	private final By searchTextBoxId 	  =By.id("search");
	private final By searchButtonLocator=By.xpath("//input[@value='Go']");
	
	//Constructor
	public HomePage (WebDriver driver) {
		  browserDriver = driver;
		  wait=new WebDriverWait(driver, 40);		  
		}
  
	/* METHODS*/

	   public void openPage() throws InterruptedException{
		   browserDriver.get(homePageUrl);		  
		   if(isOpen()==false) throw new RuntimeException("home page is not displayed");
		  }
	   
	   private boolean isOpen() {			   
			boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(HomePageTitle));
			boolean isUrlCorrect=wait.until(ExpectedConditions.urlContains(homePageUrl));
			return isTitleCorrect&&isUrlCorrect;
	   }
	   
	   public ResultsPage searchForKeyword(String keyword) {
		   typeSearchKeyword(keyword);
		   executeSearch();
		   ResultsPage resultsPage=new ResultsPage(browserDriver);
		   return resultsPage;
		}

	   private void  typeSearchKeyword(String keyword) {
		   WebElement searchTextBox=wait.until(ExpectedConditions.elementToBeClickable(searchTextBoxId));
		   searchTextBox.click();
		   searchTextBox.clear();
		   searchTextBox.sendKeys(keyword);		  
	   }
	   
	   private void executeSearch() {
		   WebElement searchButton=wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
		   searchButton.click();
	   }
}	   
