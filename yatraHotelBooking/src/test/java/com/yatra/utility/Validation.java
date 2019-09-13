package com.yatra.utility;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.yatra.base.BookingDetails;

public class Validation {
	Logger log=Logger.getLogger(BookingDetails.class);
	public void validateData(boolean isTrue, String message) {
		try {
			Assert.assertTrue(isTrue, message);
			
		} catch(AssertionError assertionError) {
		}		
	}
	
	
	public void validateCost(String actual,String expected,String message) {
		int actualCost=Validation.convertToInteger(actual);
		int expectedCost=Validation.convertToInteger(expected);
		try {
			Assert.assertEquals(actualCost, expectedCost,message);
			log.info("PASSED :"+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost);
			
		} catch(AssertionError assertionError) {
	       log.info("FAILED "+message+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost);
		}
	
	}
	public static int convertToInteger(String cost) {
	cost=cost.replace("Rs", "").replace(".", "").replace(",", "").replace("rs", "");
		int hotelcost=Integer.parseInt(cost);
		return hotelcost;
	}
	
	public void validateHotelName(String actualHotelName,String expectedHotelName,String message) {
		try {
			Assert.assertEquals(actualHotelName, expectedHotelName,message);
			log.info("PASSED :"+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName);
			
		} catch(AssertionError assertionError) {
	       log.info("FAILED "+message+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName);
		}
	
	}
	public void validateHotelRating(String actualHotelRating,String expectedHotelRating,String message) {
		 expectedHotelRating=expectedHotelRating.replace("/5", "");
		try {
			Assert.assertEquals(actualHotelRating, expectedHotelRating,message);
			log.info("PASSED: "+" actualHotelRating is: "+actualHotelRating+" expectedHotelRating is: "+ expectedHotelRating);
			
		} catch(AssertionError assertionError) {
			log.info("Failed "+message+" actualHotelRating is: "+actualHotelRating+" expectedHotelRating is: "+ expectedHotelRating);
		}
		
	}
	public void validateHotelPlace(String actualHotelPlace,String expectedHotelPlace,String message) {
		boolean isPlaceCorrect=false;
		
		if(actualHotelPlace.contains(expectedHotelPlace))
		isPlaceCorrect=true;
		
		
		try {
			Assert.assertTrue(isPlaceCorrect, message);
			log.info("PASSED: "+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace);
			
		} catch(AssertionError assertionError) {
			log.info("Failed "+message+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace);
		}
		
	}
	public void validateRating(ArrayList<String> actualratingList,ArrayList<String> sortedList,String message) {
		Collections.sort(sortedList, Collections.reverseOrder());
		try {
			Assert.assertEquals(actualratingList, sortedList,message);
			log.info("PASSED: "+" actualHotelRatings is: "+actualratingList);
			log.info(" expectedHotelRatings is: "+ sortedList);
			
		} catch(AssertionError assertionError) {
			log.info("FAILED: "+message+" actualHotelRatings is: "+actualratingList);
			log.info(" expectedHotelRatings is: "+ sortedList);
			
		}
	}
	
	
	

}