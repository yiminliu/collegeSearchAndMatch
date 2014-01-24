package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.bedrosians.bedlogic.util.FormatUtil;

@Embeddable
public class Contact implements Serializable {
	
	private static final long serialVersionUID = -127451862418201850L;
	
	@Column(name="apContact")
	private String name;	
	@Embedded
	private Phone phone;
	@Column(name="apEmail")
	private String email;
	@Column(name="apFax")
	private Long fax;
	@Column(name="apNotes")
	private String notes;
		

	public String getName() {
		return FormatUtil.process(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	//@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	//@Cascade(CascadeType.ALL)
	//@Embedded
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
			
	public String getEmail() {
		return FormatUtil.process(email);
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getFax() {
		return FormatUtil.process(fax);
	}

	public void setFax(Long fax) {
		this.fax = fax;
	}
		
	public String getNotes() {
		return FormatUtil.process(notes);
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
			
	//private String createdBy;		
	//private Date createdDate;		
	//private String lastModifiedBy;		
	//private Date lastModifiedDate;	
	
	//private int userId;
	//private Account account;
}
