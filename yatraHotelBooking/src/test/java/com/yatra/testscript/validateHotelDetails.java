package com.yatra.testscript;

import org.testng.annotations.Test;

/**
 * 
 * @author kishor.joshi
 *
 */
public class validateHotelDetails extends PaymentPage{
	
	/**
	 * validates Hotel name.
	 */
@Test(priority=8)
public void validateName(){
	validate.validateHotelNameAtBookingPage();
	validate.validateHotelNameAtPaymentPage();
}

/**
 * validates Hotel prices.
 */
@Test(priority=9)
public void validateCost() {
	validate.validateHotelCostAtPayment();
	validate.validateHotelCostAtUPI();
}

/**
 * validates hotel location
 */
@Test(priority=10)
public void validatePlace() {
	validate.validateLocationAtBookingPage();
	validate.validateLocationAtPaymentPage();
}

/**
 * validates hotel rating
 */
@Test(priority=11)
public void validateRating() {
	validate.validateSelectedHotelRating();
}
}
