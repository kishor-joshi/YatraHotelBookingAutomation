package com.yatra.testscript;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yatra.base.BaseClass;
import com.yatra.helper.ExcelReader;
import com.yatra.helper.HelperClass;

public class BookingDetails extends BaseClass {
	HelperClass help=new HelperClass();
	Properties  prop = new Properties();
	String actualHotelRating;
	String expectedHotelRating;
	String actualHotelName;
	String expectedHotelName;
	String actualHotelNameAtBookingPage;
	String actualHotelAddressAtBookingPage;
	String expectedHotelCost;
	String acutalHotelNameAtPayment;
	String acutalNumberOfPersonAtPayment;
	String acutalHotelAddressAtPayment;
	String acutalHotelRoomsAtPayment;
	String acutalHotelCostAtPayment;
	String acutalHotelCostAtUPI;
	String place;
	static String getData[][];
	
	
	@Test(priority=1)
	public void HomePagebookingDetails() throws IOException, InterruptedException {
		FileInputStream input = new FileInputStream(".\\src\\test\\resources\\locators\\locators.properties");
		prop.load(input);
	    driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	    getData=ExcelReader.getUserData(".\\src\\test\\resources\\userData\\yatraUserData.xlsx");
	    
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("selecthotel"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("placeid"))).clear();
		driver.findElement(By.xpath(prop.getProperty("placetext"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id(prop.getProperty("placeid"))).sendKeys(getData[1][0]);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		//driver.findElement(By.xpath(prop.getProperty("selectdropdown"))).click();
		driver.findElement(By.xpath(prop.getProperty("calender"))).click();
		driver.findElement(By.id(getData[1][1])).click();
		driver.findElement(By.id(getData[1][2])).click();
	   // driver.findElement(By.id(prop.getProperty("checkout"))).click();
	    
	    driver.findElement(By.xpath(prop.getProperty("travellerdetails"))).click();
	    driver.findElement(By.xpath(prop.getProperty("adultbuttonplus"))).click();
	    driver.findElement(By.xpath(prop.getProperty("addroom"))).click();
	    driver.findElement(By.xpath(prop.getProperty("searchhotelbutton"))).click();
	    
	 
	}
	@Test(priority=2)
	public void selectHotel() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("clickonimage")))).click();
	    expectedHotelName=help.getTextValue(driver, prop.getProperty("hotelnamepage2"));
	    expectedHotelRating=help.getAtributeValue(driver, prop.getProperty("expectedHotelRating"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("selecthotel2")))).click();
		
		
	    
	    
	    
	}
	@Test(priority=3)
	public void switchToNextTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		
		
		
		
		
		
		
		
	}
	@Test(priority=4)
	public void selectAndBookRoom() {
		actualHotelRating=help.getAtributeValue(driver,prop.getProperty("actualHotelRating") );
		actualHotelNameAtBookingPage=help.getTextValue(driver, prop.getProperty("hotelnamepage3"));
		actualHotelAddressAtBookingPage=help.getTextValue(driver, prop.getProperty("hoteladdresspage3"));
		driver.findElement(By.xpath(prop.getProperty("booknowroom3"))).click();
	}
	
	
	
	
	
	
	@Test(priority=5)
	public void userDetails() {
		expectedHotelCost=help.getTextValue(driver, prop.getProperty("youpay4"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(getData[1][3]);
		driver.findElement(By.xpath(prop.getProperty("phonenumber"))).sendKeys("9666609787");
		System.out.println(getData[1][4]);
		Select select=new Select(driver.findElement(By.xpath(prop.getProperty("selectfirst4"))));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname1"))).sendKeys(getData[1][5]);
		driver.findElement(By.xpath(prop.getProperty("lastname1"))).sendKeys(getData[1][6]);
		 select=new Select(driver.findElement(By.xpath(prop.getProperty("selectsecond4"))));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname2"))).sendKeys(getData[1][7]);
		driver.findElement(By.xpath(prop.getProperty("lastname2"))).sendKeys(getData[1][8]);
		driver.findElement(By.xpath(prop.getProperty("continuebutton4"))).click();
		driver.findElement(By.xpath(prop.getProperty("continuebutton4"))).click();
		
	}
	
	@Test(priority=6)
	public void paymentPage() {
	
	acutalHotelNameAtPayment=help.getAtributeValue(driver, prop.getProperty("hotelnameatpayment5"));
	acutalHotelAddressAtPayment=help.getAtributeValue(driver, prop.getProperty("hotelplacepayment5"));
	acutalHotelRoomsAtPayment=help.getAtributeValue(driver, prop.getProperty("numberofroompayment5"));
	acutalNumberOfPersonAtPayment=help.getAtributeValue(driver, prop.getProperty("numberofadultspayment5"));
	acutalHotelCostAtPayment=help.getAtributeValue(driver, prop.getProperty("totalamountrightside5"));
	acutalHotelCostAtUPI=help.getAtributeValue(driver, prop.getProperty("totalamountinupi5"));
	}
	
}
