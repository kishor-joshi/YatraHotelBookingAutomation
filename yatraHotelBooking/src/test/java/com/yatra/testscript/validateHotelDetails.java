package com.yatra.testscript;

import org.testng.annotations.Test;


public class validateHotelDetails extends PaymentPage{
	
@Test(priority=8)
public void validateName(){
	validate.validateHotelNameAtBookingPage(driver);
	validate.validateHotelNameAtPaymentPage(driver);
}


@Test(priority=9)
public void validateCost() {
	validate.validateHotelCostAtPayment(driver);
	validate.validateHotelCostAtUPI(driver);
}

@Test(priority=10)
public void validatePlace() {
	validate.validateLocationAtBookingPage(driver);
	validate.validateLocationAtPaymentPage(driver);
}


@Test(priority=11)
public void validateRating() {
	validate.validateSelectedHotelRating(driver);
}
}
