package com.yatra.helper;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	
	
	
public String getTextValue(WebDriver driver,String xpath) {
	return driver.findElement(By.xpath(xpath)).getText();
}


public WebElement explictWaitforXpath(WebDriver driver,String xpathvalue) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
return	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));
	
}
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
	 //   System.out.println(rating);
	   // Collections.sort(rating, Collections.reverseOrder());

	//    System.out.println(rating);
	    return rating;
}

}
