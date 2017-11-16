package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	
	WebDriver browserDriver;
	WebDriverWait wait;

	//fields
	private final String resultsPageTitle = "You searched for";	
	private final By resultCountLocator=By.xpath("//div[@id='main']/span[1]");
	private final By searchResultLinkLocator=By.xpath("//section[@id='pages']/article[1]/div[2]/h4/a");			
		
	//Constructor
	public ResultsPage (WebDriver driver) {
		browserDriver=driver;
		wait=new WebDriverWait(driver, 40);
		if(isOpen()==false) throw new RuntimeException("result page is not displayed");
		if(resultCount()==0) throw new RuntimeException("result count == 0");
	}

	//methods
	private boolean isOpen() {
		boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(resultsPageTitle));
		return isTitleCorrect;				
	}

	private int resultCount() {
		WebElement resultCountLabel = wait.until(ExpectedConditions.presenceOfElementLocated(resultCountLocator));
		String resultCountText=resultCountLabel.getText();
		return extractNumberFromResultCountText(resultCountText);				
	}
			
	private int extractNumberFromResultCountText(String resultCountText) {
		int startIndex = resultCountText.indexOf("OF") + 3;
		int endIndex = resultCountText.indexOf(" RESULTS");
		return Integer.parseInt(resultCountText.substring(startIndex, endIndex));
	}
	
	public ItemPage searchResult() {
		WebElement searchResultLink=wait.until(ExpectedConditions.
				elementToBeClickable(searchResultLinkLocator));		
		searchResultLink.click();
		return new ItemPage(browserDriver);		
	}
}
