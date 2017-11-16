package travelPortland;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup {
	
	private final By popupCloseLocator=By.xpath("//a[@title='Close']");							 
		
	WebDriverWait wait;
		
	//Constructor
	public Popup(WebDriver driver) {
	this.wait = new WebDriverWait(driver, 10);
	}
		
	public void close()  {
		try {			
		WebElement closeElement = wait.until(ExpectedConditions.elementToBeClickable(popupCloseLocator));
	    closeElement.click();
	    }	
		catch(Exception e) {
		//No popup
		}
	}
}
