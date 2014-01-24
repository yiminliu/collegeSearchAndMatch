package com.bedrosians.bedlogic.domain.account;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.bedrosians.bedlogic.util.FormatUtil;


@Embeddable
public class Address{

	@Column(name = "CoAddr1", nullable=false)
	protected String streeLine1;	
	@Column(name = "CoAddr2")
	protected String streeLine2;	
	@Column(name = "CoCity", nullable=false)
	protected String city;	
	@Column(name = "CoStateCd", nullable=false)
	protected String state;
	@Column(name = "CoZip")
	protected String zip;		
	//@Column(name = "CoCountryCd")
	//protected String country;
				
	public Address() {
	}
	
	
	public Address(String streeLine1, String streeLine2,
			       String addressCity, String addressState, 
			       String addressZip) {
		this.streeLine1 = streeLine1;
		this.streeLine2 = streeLine2;
		this.city = addressCity;
		this.state = addressState;
		this.zip = addressZip;
	}
	
	public String getStreeLine1() {
		return FormatUtil.process(streeLine1);
	}

	public void setStreeLine1(String streeLine1) {
		this.streeLine1 = streeLine1;
	}

	public String getStreeLine2() {
		return FormatUtil.process(streeLine2);
	}

	public void setStreeLine2(String streeLine2) {
		this.streeLine2 = streeLine2;
	}

	public String getCity() {
		return FormatUtil.process(city);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return FormatUtil.process(state);
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return FormatUtil.process(zip);
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/*public String getCountry() {
		return FormatUtil.process(country);
	}


	public void setCountry(String country) {
		this.country = country;
	}
	*/
	
}
