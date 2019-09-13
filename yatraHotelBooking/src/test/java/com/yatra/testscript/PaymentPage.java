package com.yatra.testscript;

import org.testng.annotations.Test;

public class PaymentPage extends RoomBooking{

	
	@Test(priority=7)
	public void paymentPageInformation() {
		validate.paymentPageDetails(driver);
	}
}
