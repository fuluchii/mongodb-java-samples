package me.fuluchii.java.mongo.morphia;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {
	
	private String streetName;
	private String postalCode;
	private String country;
	private String place;
	
	public Address(){
		
	}
	public Address(String streetName, String postalCode, String place, String country) {
		this.streetName = streetName;
		this.place = place;
		this.postalCode = postalCode;
		this.country = country;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
}
