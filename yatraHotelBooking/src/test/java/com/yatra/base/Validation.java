package com.yatra.base;

import org.testng.Assert;

public class Validation {

	
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
			
			System.out.println("PASSED :"+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost);
			
		} catch(AssertionError assertionError) {
	       System.out.println("FAILED "+message+" actualHotelCost is "+actualCost+" expectedHotelCost is "+ expectedCost);
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
			
			System.out.println("PASSED :"+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName);
			
		} catch(AssertionError assertionError) {
	       System.out.println("FAILED "+message+" actualHotelName is: "+actualHotelName+" expectedHotelName is: "+ expectedHotelName);
		}
	
	}
	public void validateHotelRating(String actualHotelRating,String expectedHotelRating,String message) {
		 expectedHotelRating=expectedHotelRating.replace("/5", "");
		try {
			Assert.assertEquals(actualHotelRating, expectedHotelRating,message);
			
			System.out.println("PASSED: "+" actualHotelRating is: "+actualHotelRating+" expectedHotelRating is: "+ expectedHotelRating);
			
		} catch(AssertionError assertionError) {
	          System.out.println("Failed "+message+" actualHotelRating is: "+actualHotelRating+" expectedHotelRating is: "+ expectedHotelRating);
		}
		
	}
	public void validateHotelPlace(String actualHotelPlace,String expectedHotelPlace,String message) {
		boolean isPlaceCorrect=false;
		
		if(actualHotelPlace.contains(expectedHotelPlace))
		isPlaceCorrect=true;
		
		
		try {
			Assert.assertTrue(isPlaceCorrect, message);
			
			System.out.println("PASSED: "+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace);
			
		} catch(AssertionError assertionError) {
	      System.out.println("Failed "+message+" actualHotelAddress is: "+actualHotelPlace+" expectedHotelAddress is: "+ expectedHotelPlace);
		}
		
	}
	
	

}
