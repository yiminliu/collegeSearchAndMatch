package com.collegesearch.domain.school;

// Generated Aug 10, 2015 3:42:22 PM by Hibernate Tools 4.0.0

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PrincetonReviewPopularMajor generated by hbm2java
 */
@Entity
@Table(name = "princeton_review_popular_major", catalog = "School")
public class PrincetonReviewPopularMajor implements java.io.Serializable {

	private static final long serialVersionUID = -804990758703320L;
	private Integer id;
	private String name;
	private List<School> schools = new ArrayList<School>(0);
	
	public PrincetonReviewPopularMajor() {
	}
	
	public PrincetonReviewPopularMajor(Integer id) {
		this.id = id;
	}

	public PrincetonReviewPopularMajor(String name) {
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
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bestMajors")
	public List<School> getSchools() {
		return this.schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	
}
