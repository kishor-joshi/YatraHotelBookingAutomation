package com.yatra.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.yatra.helper.ExcelReader;
import com.yatra.helper.HelperClass;
import com.yatra.base.BaseClass;
import com.yatra.utility.Constants;
import com.yatra.utility.Validation;
/**
 * 
 * @author kishor.joshi
 *
 */
public class BookingDetails extends BaseClass {
	static HelperClass help = new HelperClass();
	static Properties prop = new Properties();
	static String actualHotelRating;
	static String expectedHotelRating;
	static String actualHotelName;
	static String expectedHotelName;
	static String actualHotelNameAtBookingPage;
	static String actualHotelAddressAtBookingPage;
	static String expectedHotelCost;
	static String acutalHotelNameAtPayment;
	static String acutalNumberOfPersonAtPayment;
	static String acutalHotelAddressAtPayment;
	static String acutalHotelRoomsAtPayment;
	static String acutalHotelCostAtPayment;
	static String acutalHotelCostAtUPI;
	static String place;
	static String actualcheckIn;
	static String actualcheckout;
	ArrayList<String> ratingList, sortedList;
	static String getData[][];
	Logger log = Logger.getLogger(BookingDetails.class);
	public Validation validate = new Validation();

	/**
	 * this method is hotel booking home page.
	 * 
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void HomePagebookingDetails(WebDriver driver) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream input = new FileInputStream(Constants.LocatorsPropertiesFilePath);
		prop.load(input);
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		getData = ExcelReader.getUserData(Constants.ExcelFilePath);
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("url") + " website opened");
		driver.findElement(By.xpath(prop.getProperty("selecthotel"))).click();
		HelperClass.waitForElement();
		driver.findElement(By.id(prop.getProperty("placeid"))).clear();
		driver.findElement(By.xpath(prop.getProperty("placetext"))).click();
		HelperClass.waitForElement();
		driver.findElement(By.id(prop.getProperty("placeid"))).sendKeys(getData[1][0]);
		HelperClass.waitForElement();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(prop.getProperty("calender"))).click();
		driver.findElement(By.id(getData[1][1])).click();
		driver.findElement(By.id(getData[1][2])).click();

		driver.findElement(By.xpath(prop.getProperty("travellerdetails"))).click();
		driver.findElement(By.xpath(prop.getProperty("adultbuttonplus"))).click();
		driver.findElement(By.xpath(prop.getProperty("addroom"))).click();
		driver.findElement(By.xpath(prop.getProperty("searchhotelbutton"))).click();
		log.info("Hotel searched location is " + getData[1][0]);
		log.info("check in date " + getData[1][1] + " check out date" + getData[1][2]);
	}
	/**
	 * this method clicks on hotel rating.stores rating of all the hotels
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void HotelRating(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 4);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("clickonimage"))))
					.click();
		} catch (Exception e) {
			System.out.println("no popup");
		}
		driver.findElement(By.xpath(prop.getProperty("filterbystarrating"))).click();
		Thread.sleep(3000);
		ratingList = help.hotelRatingCollection(driver, prop.getProperty("xpathOfRatings"));
		sortedList = help.hotelRatingCollection(driver, prop.getProperty("xpathOfRatings"));

	}

	/**
	 * 
	 * @param driver
	 */
	public void selectHotel(WebDriver driver) {

		expectedHotelName = help.getTextValue(driver, prop.getProperty("hotelnamepage2"));
		expectedHotelRating = help.getAtributeValue(driver, prop.getProperty("expectedHotelRating"));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("selecthotel2")))).click();
	}
	/**
	 * switch to selected hotel tab.
	 * 
	 */
	public void switchToNextTab(WebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void selectAndBookRoom(WebDriver driver) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		actualHotelRating = help.getAtributeValue(driver, prop.getProperty("actualHotelRating3"));
		actualHotelNameAtBookingPage = help.getTextValue(driver, prop.getProperty("hotelnamepage3"));
		actualHotelAddressAtBookingPage = help.getTextValue(driver, prop.getProperty("hoteladdresspage3"));
		driver.findElement(By.xpath(prop.getProperty("booknowroom3"))).click();
	}

}
