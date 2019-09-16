package com.yatra.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
/**
 * 
 * @author kishor.joshi
 *
 */

public class PaymentPageInformation extends UserInformation{
	
	
	
	
	/**
	 * this method stores final booked hotel details at payment page.
	 * 
	 * @param driver
	 */
	public void paymentPageDetails(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
	acutalHotelNameAtPayment=help.getAtributeValue(driver, prop.getProperty("hotelnameatpayment5"));
	acutalHotelAddressAtPayment=help.getAtributeValue(driver, prop.getProperty("hotelplacepayment5"));
	acutalHotelRoomsAtPayment=help.getAtributeValue(driver, prop.getProperty("numberofroompayment5"));
	acutalNumberOfPersonAtPayment=help.getAtributeValue(driver, prop.getProperty("numberofadultspayment5"));
	acutalHotelCostAtPayment=help.getAtributeValue(driver, prop.getProperty("totalamountrightside5"));
	acutalHotelCostAtUPI=help.getAtributeValue(driver, prop.getProperty("totalamountinupi5"));
	String checkInmonth=help.getAtributeValue(driver, prop.getProperty("checkinmonth"));
	String checkInDate=help.getAtributeValue(driver, prop.getProperty("chechindate"));
	actualcheckIn=checkInDate+checkInmonth;
	String checkOutMonth=help.getAtributeValue(driver, prop.getProperty("checkoutmonth"));
	String checkOutDate=help.getAtributeValue(driver, prop.getProperty("checkoutdate"));
	actualcheckout=checkOutDate+checkOutMonth;
	
	log.info("Booking Details:");
	log.info("Hotel Name: "+actualHotelNameAtBookingPage);
	log.info("Hotel Address: "+actualHotelAddressAtBookingPage);
	log.info("no. of rooms: "+acutalHotelRoomsAtPayment+" no. of persons: " +acutalNumberOfPersonAtPayment);
	}
}
