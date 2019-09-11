package com.yatra.base;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
			System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
			 driver = new ChromeDriver(optionschrome);
			//System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
			//driver = new ChromeDriver();
			break;
			
		case "firefox":
			FirefoxOptions optionsfirefox=new FirefoxOptions();
			optionsfirefox.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
			driver = new ChromeDriver(optionsfirefox);
			//driver = new FirefoxDriver();
			break;
			
		case "ie":
			
			System.setProperty("webdriver.ie.driver", "./libs/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
	}
	

}
