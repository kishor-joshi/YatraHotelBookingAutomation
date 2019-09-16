package com.yatra.testscript;

import org.testng.annotations.Test;
/**
 * 
 * @author kishor.joshi
 *
 */
public class ValidateUserDetails extends validateHotelDetails{

	/**
	 * validates filter by rating
	 */
	@Test(priority=12)
	public void validateSortByRatings() {
		validate.validateHotelRatings();
	}
	
	/**
	 * validates check in date.
	 */
	@Test(priority=13)
	public void validateCheckIn() {
		validate.validateHotelCheckingDate();
	}
	
	/**
	 * validates total rooms
	 */
	@Test(priority=14)
	public void validateTotalRooms() {
		validate.validateRoomNumbers();
	}
	
	/**
	 * validates total members
	 */
	@Test(priority=15)
	public void validateTotalMembers() {
		validate.validateTotalMemberNumers();
	}
}
