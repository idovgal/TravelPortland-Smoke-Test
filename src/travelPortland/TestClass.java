package travelPortland;

import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	
	WebDriver driver;	
	
	private final String keyword="jazz";
		
	@BeforeTest
	public void SetUp() {			
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Igor\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver=new FirefoxDriver();		
	}
		
	@AfterTest 
	public void tearDown() {
	driver.quit();
	}
	
	@Test
	public void testMainPagesLinks () throws InterruptedException {
	
		HomePage homePage = new HomePage(driver);
		homePage.openPage();	
		
		ThingsToDoPage thingsToDoPage = new ThingsToDoPage(driver);
		thingsToDoPage.openPage();
		
		PlacesToVisitPage placesToVisitPage = new PlacesToVisitPage(driver);
		placesToVisitPage.openPage();
				
		PlanYouTripPage planYouTripPage = new PlanYouTripPage(driver);
		planYouTripPage.openPage();
}	
	@Test
	public void testSearch () throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.openPage();		
				
		ResultsPage resultsPage = homePage.searchForKeyword(keyword);				
		
		ItemPage itemPage = resultsPage.searchResult();			
						
		assertTrue(itemPage.itemTitle().contains(keyword),
				"Wrong search results!");			
	} 
}
