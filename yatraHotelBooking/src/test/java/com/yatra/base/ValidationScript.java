package com.yatra.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.yatra.utility.Validation;

public class ValidationScript extends BookingDetails{

	
	public void validateHotelNameAtBookingPage(WebDriver driver) {
		validate.validateHotelName(actualHotelNameAtBookingPage, expectedHotelName, "Hotel name Not matched at Booking page");
	}
	
	public void validateHotelNameAtPaymentPage(WebDriver driver) {
		validate.validateHotelName(acutalHotelNameAtPayment, expectedHotelName, "Hotel name not matched at payment page");
	}
	
	public void validateLocationAtBookingPage(WebDriver driver) {
		validate.validateHotelPlace(actualHotelAddressAtBookingPage, "Bangalore", "Not correct loaction");
		
	}
	public void validateLocationAtPaymentPage(WebDriver driver) {
		validate.validateHotelPlace(acutalHotelAddressAtPayment, "Bangalore", "Location not matched");
	}
	public void validateSelectedHotelRating(WebDriver driver) {
		validate.validateHotelRating(actualHotelRating, expectedHotelRating, "Hotel rating not matched");
	}
	
	public void validateHotelCostAtPayment(WebDriver driver) {
		validate.validateCost(acutalHotelCostAtPayment, expectedHotelCost, "Cost is Not matched at payment");
	}
	public void validateHotelCostAtUPI(WebDriver driver) {
		validate.validateCost(acutalHotelCostAtUPI, expectedHotelCost, "cost is Not matched at UPI");
	}
	public void validateHotelRatings(WebDriver driver) {
		validate.validateRating(ratingList,sortedList, "Sorted by star Rating not met");
	}
	
}


