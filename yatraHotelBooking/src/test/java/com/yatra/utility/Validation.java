package com.yatra.utility;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.yatra.base.BookingDetails;
import com.yatra.helper.HelperClass;
/**
 * 
 * @author kishor.joshi
 *
 */
public class Validation {
	Logger log=Logger.getLogger(BookingDetails.class);
	
	
	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void validateCost(String actual,String expected,String message) {
		int actualCost=Validation.convertToInteger(actual);
		int expectedCost=Validation.convertToInteger(expected);
		message=message+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost;
		
			Assert.assertEquals(actualCost, expectedCost,message);
			log.info("PASSED :"+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost);
			
		
	
	}
	/**
	 * 
	 * @param cost
	 * @return
	 */
	public static int convertToInteger(String cost) {
	cost=cost.replace("Rs", "").replace(".", "").replace(",", "").replace("rs", "");
		int hotelcost=Integer.parseInt(cost);
		return hotelcost;
	}
	/**
	 * 
	 * @param actualHotelName
	 * @param expectedHotelName
	 * @param message
	 */
	public void validateHotelName(String actualHotelName,String expectedHotelName,String message) {
	String	expectedHotelNameArr[]=expectedHotelName.split("\\s+");
	boolean isnamecontains=false;
	for(int i=0;i<expectedHotelNameArr.length;i++) {
		if(actualHotelName.contains(expectedHotelNameArr[i])) {
			isnamecontains=true;
		}
	else
			isnamecontains=false;
		break;
	}
	message=message+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName;
			Assert.assertTrue(isnamecontains, message);
			log.info("PASSED :"+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName);
	}
	
	/**
	 * 
	 * @param actualHotelRating
	 * @param expectedHotelRating
	 * @param message
	 */
	public void validateHotelRating(String actualHotelRating,String expectedHotelRating,String message) {
		 expectedHotelRating=expectedHotelRating.replace("/5", "");
		
			Assert.assertEquals(actualHotelRating, expectedHotelRating,message);
			log.info("PASSED: "+" actualHotelRating is: "+actualHotelRating+" expectedHotelRating is: "+ expectedHotelRating);
		
	}
	
	/**
	 * 
	 * @param actualHotelPlace
	 * @param expectedHotelPlace
	 * @param message
	 */
	public void validateHotelPlace(String actualHotelPlace,String expectedHotelPlace,String message) {
		boolean isPlaceCorrect=false;
		
		if(actualHotelPlace.contains(expectedHotelPlace))
		isPlaceCorrect=true;
		message=message+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace;
		
		
			Assert.assertTrue(isPlaceCorrect, message);
			log.info("PASSED: "+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace);
			
	}
	
	/**
	 * 
	 * @param actualratingList
	 * @param sortedList
	 * @param message
	 */
	public void validateRating(ArrayList<String> actualratingList,ArrayList<String> sortedList,String message) {
		Collections.sort(sortedList, Collections.reverseOrder());
		message=message+" actualHotelRatings is: "+actualratingList+" expectedHotelRatings is: "+sortedList;
		
			Assert.assertEquals(actualratingList, sortedList,message);
			log.info("PASSED: "+" actualHotelRatings is: "+actualratingList);
			log.info(" expectedHotelRatings is: "+ sortedList);
			
		
			
			//log.error("FAILED: "+message+" actualHotelRatings is: "+actualratingList);
			//log.error(" expectedHotelRatings is: "+ sortedList);
		
	}
	
	/**
	 * 
	 * @param actualDate
	 * @param expectedDate
	 * @param message
	 */
public void validateDate(String actualDate,String expectedDate,String message) {
	expectedDate=HelperClass.converttoMonth(expectedDate);
	boolean ischeckinsame=false;
	if(actualDate.contains(expectedDate))
		ischeckinsame=true;
	
		Assert.assertTrue(ischeckinsame,message);
		log.info("PASSED: "+" actualDate is: "+actualDate+" expectedDate is: "+ expectedDate);
		
	
	}


/**
 * 
 * @param actualRooms
 * @param expectedRooms
 * @param message
 */
public void validateRooms(String actualRooms,String expectedRooms,String message) {
	
		Assert.assertEquals(actualRooms, expectedRooms,message);
		log.info("PASSED: "+" actualRooms is: "+actualRooms+" expectedRooms is: "+ expectedRooms);
	
}

/**
 * 
 * @param actualTotalMembers
 * @param expectedTotalMembers
 * @param message
 */
public void validateTotalMembers(String actualTotalMembers,String expectedTotalMembers,String message) {
	
		Assert.assertEquals(actualTotalMembers, expectedTotalMembers,message);
		log.info("PASSED: "+" actualTotalMembers is: "+actualTotalMembers+" expectedTotalMembers is: "+ expectedTotalMembers);
	
}

}
