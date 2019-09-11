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
import com.yatra.helper.HelperClass;

public class BookingDetails extends BaseClass {
	HelperClass help=new HelperClass();
	Properties  prop = new Properties();
	
    
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	@Test(priority=1)
	public void HomePagebookingDetails() throws IOException, InterruptedException {
		FileInputStream input = new FileInputStream(".\\src\\test\\resources\\locators\\locators.properties");
		prop.load(input);
	    
	    driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("selecthotel"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("placeid"))).clear();
		driver.findElement(By.xpath(prop.getProperty("placetext"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id(prop.getProperty("placeid"))).sendKeys("Bangalore");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		//driver.findElement(By.xpath(prop.getProperty("selectdropdown"))).click();
		driver.findElement(By.xpath(prop.getProperty("calender"))).click();
		driver.findElement(By.id(prop.getProperty("checkin"))).click();
	    driver.findElement(By.id(prop.getProperty("checkout"))).click();
	    
	    driver.findElement(By.xpath(prop.getProperty("travellerdetails"))).click();
	    driver.findElement(By.xpath(prop.getProperty("adultbuttonplus"))).click();
	    driver.findElement(By.xpath(prop.getProperty("addroom"))).click();
	    driver.findElement(By.xpath(prop.getProperty("searchhotelbutton"))).click();
	    
	  
	 
	}
	@Test(priority=2)
	public void selectHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("clickonimage")))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("selecthotel2")))).click();
		//help.explictWaitforXpath(driver, prop.getProperty("clickonimage"));
		//help.explictWaitforXpath(driver, prop.getProperty("selecthotel2"));
		
	}
	@Test(priority=3)
	public void switchToNextTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	@Test(priority=4)
	public void selectAndBookRoom() {
		driver.findElement(By.xpath(prop.getProperty("booknowroom3"))).click();
	}
	
	
	@Test(priority=5)
	public void userDetails() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys("as@gmail.com");
		driver.findElement(By.xpath(prop.getProperty("phonenumber"))).sendKeys("9666609787");
		Select select=new Select(driver.findElement(By.xpath(prop.getProperty("selectfirst4"))));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname1"))).sendKeys("krishh");
		driver.findElement(By.xpath(prop.getProperty("lastname1"))).sendKeys("krishh");
		 select=new Select(driver.findElement(By.xpath(prop.getProperty("selectsecond4"))));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname2"))).sendKeys("krishh");
		driver.findElement(By.xpath(prop.getProperty("lastname2"))).sendKeys("krishh");
		driver.findElement(By.xpath(prop.getProperty("continuebutton4"))).click();
		driver.findElement(By.xpath(prop.getProperty("continuebutton4"))).click();
		
	}
	
	@Test(priority=6)
	public void paymentPage() {
	String hotelname=	help.getTextValue(driver, prop.getProperty("hotelnameatpayment5"));
	String hotelPlace=help.getTextValue(driver, prop.getProperty("hotelplacepayment5"));
	String numberOfrooms=help.getAtributeValue(driver, prop.getProperty(""));
	String numberOfPersons=help.getAtributeValue(driver, prop.getProperty(""));
	String totalAmountAtPaymentSide=help.getAtributeValue(driver, prop.getProperty("totalamountrightside5"));
	String totalAmountAtUPIpayment=help.getAtributeValue(driver, prop.getProperty("totalamountinupi5"));
	System.out.println("Hotel Name "+hotelname);
	System.out.println("Hotel location "+hotelPlace);
	System.out.println(" number of rooms booked "+numberOfrooms);
	System.out.println("number of persons "+numberOfPersons);
	System.out.println("total amount at payment page "+totalAmountAtPaymentSide);
	System.out.println("total amount at UPI page "+totalAmountAtUPIpayment);
	}
	
}
