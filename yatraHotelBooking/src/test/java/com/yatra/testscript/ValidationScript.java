package com.yatra.testscript;

import org.testng.annotations.Test;

import com.yatra.base.Validation;

public class ValidationScript extends BookingDetails{

	Validation validate=new Validation();	

	
	@Test(priority=7)
	public void validateHotelNameAtBookingPage() {
		validate.validateHotelName(actualHotelNameAtBookingPage, expectedHotelName, "Hotel name Not matched at Booking page");
	}
	
	@Test(priority=8)
	public void validateHotelNameAtPaymentPage() {
		validate.validateHotelName(acutalHotelNameAtPayment, expectedHotelName, "Hotel name not matched at payment page");
	}
	
	@Test(priority=9)
	public void validateLocationAtBookingPage() {
		validate.validateHotelPlace(actualHotelAddressAtBookingPage, "Bangalore", "Not correct loaction");
		
	}
	@Test(priority=10)
	public void validateLocationAtPaymentPage() {
		validate.validateHotelPlace(acutalHotelAddressAtPayment, "Bangalore", "Location not matched");
	}
	@Test(priority=11)
	public void validateSelectedHotelRating() {
		validate.validateHotelRating(actualHotelRating, expectedHotelRating, "Hotel rating not matched");
	}
	
	@Test(priority=12)
	public void validateHotelCostAtPayment() {
		validate.validateCost(acutalHotelCostAtPayment, expectedHotelCost, "Cost is Not matched at payment");
	}
	@Test(priority=12)
	public void validateHotelCostAtUPI() {
		validate.validateCost(acutalHotelCostAtUPI, expectedHotelCost, "cost is Not matched at UPI");
	}
	
	
	
	
	
	
}











