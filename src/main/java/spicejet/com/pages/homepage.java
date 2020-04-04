package spicejet.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import spicejet.com.utilities.ExcelUtils;
import spicejet.com.utilities.GetProperty;

public class homepage {
	public homepage(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	WebDriver driver;	
	String filename = "homepage.properties";
	GetProperty gp = new GetProperty(filename);
	
	public void setDepartureCity() throws Exception{
		ExcelUtils.setExcelFile("bookpage");
		driver.findElement(By.xpath(gp.getValue("From"))).click();
		String dCity = ExcelUtils.getCellData(1, 0);
		System.out.println(dCity);
		if(dCity.equals("HYD")){
		driver.findElement(By.xpath(gp.getValue("dCityHYD"))).click();
		}
	}
	public void setDepCity(String dCity) throws Exception{
		driver.findElement(By.xpath(gp.getValue("From"))).click();
		if(dCity.equals("HYD")){
			driver.findElement(By.xpath(gp.getValue("dCityHYD"))).click();
			}
		else if(dCity.equals("GOI")){
			driver.findElement(By.xpath(gp.getValue("dCityGOI"))).click();
		}
		else if(dCity.equals("CJB")){
			driver.findElement(By.xpath(gp.getValue("dCityCJB"))).click();
		}
	}
	public void setArrivalCity() throws Exception {
		ExcelUtils.setExcelFile("bookpage");
		driver.findElement(By.xpath(gp.getValue("To"))).click();
		String rCity = ExcelUtils.getCellData(1, 1);
		System.out.println(rCity);
		if(rCity.equals("GOI")){
		driver.findElement(By.xpath(gp.getValue("aCityGOI"))).click();
		}
	}
	public void setArrCity(String aCity) throws Exception {
		driver.findElement(By.xpath(gp.getValue("To"))).click();
		if(aCity.equals("GOI")){
			driver.findElement(By.xpath(gp.getValue("aCityGOI"))).click();
			}
		else if(aCity.equals("HYD")){
			driver.findElement(By.xpath(gp.getValue("aCityHYD"))).click();
			}
		else if(aCity.equals("CJB")){
			driver.findElement(By.xpath(gp.getValue("aCityCJB"))).click();
			}
		
	}
	public void setDepatDate() throws Exception{
		driver.findElement(By.xpath(gp.getValue("departDate"))).click();
		driver.findElement(By.xpath("//td[@data-month='6']//a[text()='29']")).click();
	}
	public void setReturnDate() throws Exception{
		driver.findElement(By.xpath(gp.getValue("returnDate"))).click();
		driver.findElement(By.xpath("//td[@data-month='6']//a[text()='30']")).click();
	}
	public void clickSearchBtn() throws Exception{
		driver.findElement(By.xpath(gp.getValue("searchBtn"))).click();
	}
	public void getTitle() throws Exception{
		System.out.println(driver.getTitle());
		
	}
}
