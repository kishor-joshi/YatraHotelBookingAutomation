package com.yatra.helper;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author kishor.joshi
 *
 */

public class HelperClass {
	/**
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	
	
public String getTextValue(WebDriver driver,String xpath) {
	return driver.findElement(By.xpath(xpath)).getText();
}

/**
 * 
 * @param driver
 * @param xpathvalue
 * @return
 */
public WebElement explictWaitforXpath(WebDriver driver,String xpathvalue) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
return	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));
	
}

/**
 * 
 * @param driver
 * @param xpath
 * @return
 */
public String getAtributeValue(WebDriver driver,String xpath) {
	return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
}
public ArrayList<String> hotelRatingCollection(WebDriver driver,String xpathOfRatings) {
	 ArrayList<WebElement>ratinglist= (ArrayList<WebElement>) driver.findElements(By.xpath(xpathOfRatings));
	   ArrayList<String>rating=new ArrayList<String>();
	    for(int i=0;i<ratinglist.size();i++) {
	    	String filter=ratinglist.get(++i).getText().replace("/5", "");
	    	rating.add(filter);
	    }
	
	    return rating;
}
/**
 * this method converts month number into Alphabetic month
 * 
 * @param date
 * @return
 */
public static String converttoMonth(String date) {
	String checkIn[]=date.split("/");
	String month=checkIn[1];
	String monthInAlphabet="";
	switch(month) {
	case "01":
		monthInAlphabet="January";
		break;
	case "02":
		monthInAlphabet="February";
		break;
	case "03":
		monthInAlphabet="March";
		break;
	case "04":
		monthInAlphabet="April";
		break;
	case "05":
		monthInAlphabet="May";
		break;
	case "06":
		monthInAlphabet="June";
		break;
	case "07":
		monthInAlphabet="July";
		break;
	case "08":
		monthInAlphabet="August";
		break;
	case "09":
		monthInAlphabet="September";
		break;
	case "10":
		monthInAlphabet="October";
		break;
		case "11":
			monthInAlphabet="November";
			break;
		case "12":
			monthInAlphabet="December";
	}
	return checkIn[0]+monthInAlphabet;
}
public static void waitForElement() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
