package com.bedrosians.bedlogic.domain.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Applications {

	@Column(name = "application", length = 20)
	private String application;
	@Column(name = "residential", length = 20)
	private String residential;
	@Column(name = "lightcommercial", length = 20)
	private String lightcommercial;
	@Column(name = "commercial", length = 20)
	private String commercial;
	
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getResidential() {
		return residential;
	}
	public void setResidential(String residential) {
		this.residential = residential;
	}
	public String getLightcommercial() {
		return lightcommercial;
	}
	public void setLightcommercial(String lightcommercial) {
		this.lightcommercial = lightcommercial;
	}
	public String getCommercial() {
		return commercial;
	}
	public void setCommercial(String commercial) {
		this.commercial = commercial;
	}
	
		
}
