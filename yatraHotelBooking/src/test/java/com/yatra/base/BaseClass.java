package com.yatra.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.yatra.extendreport.YatraExtendReport;
import com.yatra.utility.Constants;

public class BaseClass {
	public  WebDriver driver;
/**
 * select driver class type
 * 
 * @param selecteddriver
 * @throws IOException
 */
	
	@Parameters("selecteddriver")
	@BeforeTest
	public void setBrowser(String selecteddriver) throws IOException {
		
		switch (selecteddriver) {
		
		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
			 driver = new ChromeDriver(optionschrome);
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.fireFoxDriverPath);
			
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			
			System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);
			driver = new InternetExplorerDriver();
			break;
		}
	}
	

}
