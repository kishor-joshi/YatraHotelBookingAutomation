package com.yatra.helper;

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

}
