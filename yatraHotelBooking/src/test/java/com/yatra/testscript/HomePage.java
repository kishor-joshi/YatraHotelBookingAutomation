package com.yatra.testscript;

import java.io.IOException;
import org.testng.annotations.Test;
import com.yatra.base.BaseClass;
import com.yatra.base.ValidationScript;



public class HomePage extends BaseClass{
	
 ValidationScript validate=new ValidationScript();
 
 
 
 @Test(priority=1)
 public void bookingInforamtion() throws IOException, InterruptedException {
	 System.out.println(validate);
	 validate.HomePagebookingDetails(driver);
 }
	
 
 
 
 @Test(priority = 2)
 public void sortedByRating() throws InterruptedException {
	 validate.HotelRating(driver);
 }
 
 
 
 @Test(priority=3)
 public void hotelSelection() {
	 validate.selectHotel(driver);
 }
 
 
 @Test(priority=4)
 public void switchToHotelTab() {
	 validate.switchToNextTab(driver);
 }
}
