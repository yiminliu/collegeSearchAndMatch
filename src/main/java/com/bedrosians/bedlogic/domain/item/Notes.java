package com.bedrosians.bedlogic.domain.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Notes implements java.io.Serializable {
			
	@Column(name = "po_notes", length = 35)
	private String poNotes;		
	@Column(name = "notes1", length = 35)
	private String notes1;	
	@Column(name = "notes2", length = 35)
	private String notes2;
	
	
	public String getPoNotes() {
		return poNotes;	}

	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}

	public String getNotes1() {
		return notes1;
	}

	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}

	public String getNotes2() {
		return notes2;
	}

	public void setNotes2(String notes2) {
		this.notes2 = notes2;
	}

	public String getNotes3() {
		return notes3;
	}

	public void setNotes3(String notes3) {
		this.notes3 = notes3;
	}

	@Column(name = "notes3", length = 35)
	private String notes3;
	
	
}	
