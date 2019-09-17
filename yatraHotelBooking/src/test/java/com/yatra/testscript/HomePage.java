package com.yatra.testscript;

import java.io.IOException;

import org.testng.annotations.Test;
import com.yatra.base.BaseClass;
import com.yatra.base.ValidationScript;

/**
 * HomePage
 */

public class HomePage extends BaseClass{
	
 ValidationScript validate=new ValidationScript();
 
 /**
  * this method gives Hotel Booking information
  * @throws IOException
  * @throws InterruptedException
  */
 
 @Test(priority=1)
 public void bookingInforamtion() throws IOException, InterruptedException {
	 System.out.println(validate);
	 validate.HomePagebookingDetails(driver);
 }
	
 
 /**
  * 
  * @throws InterruptedException
  */
 @Test(priority = 2)
 public void sortedByRating() throws InterruptedException {
	 validate.HotelRating(driver);
 }
 
 /**
  * clicks on selected hotel
  */
 @Test(priority=3)
 public void hotelSelection() {
	 validate.selectHotel(driver);
 }
 
 /**
  * switches to selected hotel tab
  */
 @Test(priority=4)
 public void switchToHotelTab() {
	 validate.switchToNextTab(driver);
 }
}
