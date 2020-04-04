package spicejet.com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import spicejet.com.pages.homepage;
import spicejet.com.utilities.Testbase;

public class testHompage {
	public WebDriver driver;
	homepage homepage;
	Testbase testbase;
	public testHompage() throws Exception{
		super();
		
	}	
	@Test(groups="title")
	public void ValidateTitle() throws Exception{
		homepage.getTitle();
	} 
	@Test
	public void clickSearch() throws Exception{
		homepage.setDepartureCity();
		homepage.setArrivalCity();
		homepage.setDepatDate();
		homepage.setReturnDate();
		homepage.clickSearchBtn();
	}
	@Test(dataProvider = "getBusesSearchInfoByGroup", dataProviderClass=spicejet.com.utilities.dataProvider.class , groups = "Regression")
	public void searchBuses(String dCity, String aCity) throws Exception{
		homepage.setDepCity(dCity);
		homepage.setArrCity(aCity);
		homepage.setDepatDate();
		homepage.setReturnDate();
		homepage.clickSearchBtn();
	}
	@BeforeMethod(groups={"title", "Regression"})
	@Parameters ({"browser", "homepageURL"})
	public void loadDriver(String browser, String URL) throws Exception{
		testbase = new Testbase();
		driver = testbase.setUpDriver(browser, URL);
		homepage = new homepage(driver);		
	}	

	@AfterMethod(groups={"title", "Regression"})
	public void tearDown(){
		driver.close();
	}
}
