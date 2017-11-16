package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
	WebDriver browserDriver;
	WebDriverWait wait;

	//fields	
	private final String pageTitle = "Portland jazz - Travel Portland";	
	private final By itemNameId =By.xpath("//div[@id='main']/div[2]/div[1]/h1");
	
	//Constructor
	public ItemPage (WebDriver driver) {
	browserDriver=driver;
	wait=new WebDriverWait(driver, 40);
	
	if(isOpen()==false) throw new RuntimeException("item page is not displayed");
	}

	//methods
	private boolean isOpen() {
		boolean isTitleCorrect=wait.until(ExpectedConditions.titleContains(pageTitle));
		return isTitleCorrect;		
	}
	public String itemTitle() {
		WebElement firstItem = wait.until(ExpectedConditions.presenceOfElementLocated(itemNameId));
		String title=firstItem.getText();
		return title;		
	}
}
