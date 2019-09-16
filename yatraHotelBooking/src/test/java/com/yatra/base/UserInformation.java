package com.yatra.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author kishor.joshi
 *
 */
public class UserInformation extends BookingDetails{

	
	/**
	 * 
	 * this takes user details.
	 * 
	 * @param driver
	 */
	public void userDetails(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		expectedHotelCost=help.getTextValue(driver, prop.getProperty("youpay4"));
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(getData[1][3]);
		String phoneNo=getData[1][4].replace("E9", "").replace(".", "");
		driver.findElement(By.xpath(prop.getProperty("phonenumber"))).sendKeys(phoneNo);
		Select select=new Select(driver.findElement(By.xpath(prop.getProperty("selectfirst4"))));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname1"))).sendKeys(getData[1][5]);
		driver.findElement(By.xpath(prop.getProperty("lastname1"))).sendKeys(getData[1][6]);
		Select select1=new Select(driver.findElement(By.xpath(prop.getProperty("selectsecond4"))));
		select1.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(prop.getProperty("firstname2"))).sendKeys(getData[1][7]);
		driver.findElement(By.xpath(prop.getProperty("lastname2"))).sendKeys(getData[1][8]);
		driver.findElement(By.xpath(prop.getProperty("continuebutton4"))).click();
		log.info("user datails in roomNo.1 "+getData[1][5]+" "+getData[1][6]);
		log.info("user datails in roomNo.2 "+getData[1][7]+" "+getData[1][8]);
		
	}
}
