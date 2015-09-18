package com.collegesearch.domain.school;

// Generated Aug 10, 2015 3:17:49 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UsNewsProgram generated by hbm2java
 */
@Entity
@Table(name = "us_news_program", catalog = "School")
public class UsNewsProgram implements java.io.Serializable {

	private static final long serialVersionUID = -540040758703320L;
	
	private Integer id;
	private String name;

	public UsNewsProgram() {
	}

	public UsNewsProgram(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
