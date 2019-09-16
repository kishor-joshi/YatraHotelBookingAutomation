package com.yatra.testscript;

import org.testng.annotations.Test;
/**
 * 
 * @author kishor.joshi
 *
 */
public class PaymentPage extends RoomBooking{

	/**
	 * gives Booking information at payment page.
	 */
	@Test(priority=7)
	public void paymentPageInformation() {
		validate.paymentPageDetails(driver);
	}
}
