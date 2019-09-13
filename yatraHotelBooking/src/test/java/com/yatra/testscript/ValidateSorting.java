package com.yatra.testscript;

import org.testng.annotations.Test;

public class ValidateSorting extends validateHotelDetails{

	@Test(priority=12)
	public void validateSortByRatings() {
		validate.validateHotelRatings(driver);
	}
}
