package com.yatra.base;



/**
 * 
 * @author kishor.joshi
 *
 */
public class ValidationScript extends PaymentPageInformation{
	
	
/**
 * validates Hotel name at booking page.
 */
	public void validateHotelNameAtBookingPage() {
		validate.validateHotelName(actualHotelNameAtBookingPage, expectedHotelName, "Hotel name Not matched at Booking page");
	}
	
	
	/**
	 * validates Hotel Name at payment page.
	 */
	public void validateHotelNameAtPaymentPage() {
		validate.validateHotelName(acutalHotelNameAtPayment, expectedHotelName, "Hotel name not matched at payment page");
	}
	
	
	/**
	 * validates Hotel Location at Booking page
	 */
	public void validateLocationAtBookingPage() {
		validate.validateHotelPlace(actualHotelAddressAtBookingPage, getData[1][0], "Not correct loaction");
		
	}
	
	/**
	 * validates Hotel Location at payment page
	 */
	public void validateLocationAtPaymentPage() {
		validate.validateHotelPlace(acutalHotelAddressAtPayment, getData[1][0], "Location not matched");
	}
	
	/**
	 * validates Hotel Rating
	 */
	public void validateSelectedHotelRating() {
		validate.validateHotelRating(actualHotelRating, expectedHotelRating, "Hotel rating not matched");
	}
	
	/**
	 * validates Hotel price
	 */
	public void validateHotelCostAtPayment() {
		validate.validateCost(acutalHotelCostAtPayment, expectedHotelCost, "Cost is Not matched at payment");
	}
	
	/**
	 * validates Hotel price at UPI
	 */
	public void validateHotelCostAtUPI() {
		validate.validateCost(acutalHotelCostAtUPI, expectedHotelCost, "cost is Not matched at UPI");
	}
	
	/**
	 * validates filter by Hotel Rating
	 */
	public void validateHotelRatings() {
		validate.validateRating(ratingList,sortedList, "Sorted by star Rating not met");
	}
	
	/**
	 * validates checkIn date
	 */
	public void validateHotelCheckingDate() {
		validate.validateDate(actualcheckIn, getData[1][1], "check in date not matched");
		validate.validateDate(actualcheckout, getData[1][2], "check out date not matched");
		
	}
	
	/**
	 * validates total room numbers
	 */
	public void validateRoomNumbers() {
		validate.validateRooms(acutalHotelRoomsAtPayment,prop.getProperty("totalrooms") , "rooms are not matched");
	}
	
	/**
	 * validates total members
	 */
	public void validateTotalMemberNumers() {
		validate.validateTotalMembers(acutalNumberOfPersonAtPayment, prop.getProperty("totalpersons"), "total members numbers are not matched");
	}
}


