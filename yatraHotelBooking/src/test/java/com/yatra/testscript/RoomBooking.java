package com.yatra.testscript;

import org.testng.annotations.Test;

public class RoomBooking extends HomePage{

	@Test(priority=5)
	public void selectRooms() {
		validate.selectAndBookRoom(driver);
	}
	
	
	@Test(priority=6)
	public void userInformation() {
		validate.userDetails(driver);
	}
	
}
