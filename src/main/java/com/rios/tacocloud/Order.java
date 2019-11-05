package com.rios.tacocloud;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

public class Order {
	@NotNull
	private Long id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((ccCVV == null) ? 0 : ccCVV.hashCode());
		result = prime * result + ((ccExpiration == null) ? 0 : ccExpiration.hashCode());
		result = prime * result + ((ccNumber == null) ? 0 : ccNumber.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (ccCVV == null) {
			if (other.ccCVV != null)
				return false;
		} else if (!ccCVV.equals(other.ccCVV))
			return false;
		if (ccExpiration == null) {
			if (other.ccExpiration != null)
				return false;
		} else if (!ccExpiration.equals(other.ccExpiration))
			return false;
		if (ccNumber == null) {
			if (other.ccNumber != null)
				return false;
		} else if (!ccNumber.equals(other.ccNumber))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (state != other.state)
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@NotBlank(message="First name is required")
	private String firstName;
	@NotBlank(message="Last name is required")
	private String lastName;
	@NotBlank(message="Address is required")
	private String address;
	@NotBlank(message="City is required")
	private String city;
	private State state;
	@NotBlank(message="Zip is required")
	private String zip;
	@CreditCardNumber(message="Credit Card Number is required")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCcNumber() {
		return ccNumber;
	}


	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}


	public String getCcExpiration() {
		return ccExpiration;
	}


	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}


	public String getCcCVV() {
		return ccCVV;
	}


	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	@Override
	public String toString() {
		return "Order [id =" + id + "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", ccNumber=" + ccNumber + ", ccExpiration=" + ccExpiration
				+ ", ccCVV=" + ccCVV + "]";
	}


	public Order(Long id, String firstName, String lastName, String address, String city, State state, String zip,
			String ccNumber, String ccExpiration, String ccCVV) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ccNumber = ccNumber;
		this.ccExpiration = ccExpiration;
		this.ccCVV = ccCVV;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static enum State {
		AL("AL"),
		AK("AK"),
		AZ("AZ"),
		AR("AR"),
		CA("CA"),
		CO("CO"),
		CT("CT"),
		DE("DE"),
		FL("FL"),
		GA("GA"),
		HI("HI"),
		ID("ID"),
		IL("IL"),
		IN("IN"),
		IA("IA"),
		KS("KS"),
		KY("KY"),
		LA("LA"),
		ME("ME"),
		MD("MD"),
		MA("MA"),
		MI("MI"),
		MN("MN"),
		MS("MS"),
		MO("MO"),
		MT("MT"),
		NE("NE"),
		NV("NV"),
		NH("NH"),
		NJ("NJ"),
		NM("NM"),
		NY("NY"),
		NC("NC"),
		ND("ND"),
		OH("OH"),
		OK("OK"),
		OR("OR"),
		PA("PA"),
		RI("RI"),
		SC("SC"),
		SD("SD"),
		TN("TN"),
		TX("TX"),
		UT("UT"),
		VT("VT"),
		VA("VA"),
		WA("WA"),
		WV("WV"),
		WI("WI"),
		WY("WY");
		
		private final String stateCode;
		
		private State(String stateCode) {
			this.stateCode = stateCode;
		}
		
		public String getDisplayName() {
			return stateCode;
		}
		
	}	
}
