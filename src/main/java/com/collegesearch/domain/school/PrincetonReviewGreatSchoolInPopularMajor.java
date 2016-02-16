package com.collegesearch.domain.school;

// Generated Aug 10, 2015 3:42:22 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * PrincetonReviewGreatSchoolInPopularMajor generated by hbm2java
 * Table "princeton_review_great_school_major" is a join table for school and best majors
 */
@Entity
@Table(name = "princeton_review_great_school_major", catalog = "School")
public class PrincetonReviewGreatSchoolInPopularMajor implements java.io.Serializable {

	private static final long serialVersionUID = -85490758703320L;
	private PrincetonReviewGreatSchoolInPopularMajorId id;
	
	public PrincetonReviewGreatSchoolInPopularMajor() {
	}

	public PrincetonReviewGreatSchoolInPopularMajor(PrincetonReviewGreatSchoolInPopularMajorId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "schoolId", column = @Column(name = "School_Id", nullable = false)),
			@AttributeOverride(name = "majorId", column = @Column(name = "Major_Id", nullable = false)) })
	public PrincetonReviewGreatSchoolInPopularMajorId getId() {
		return this.id;
	}

	public void setId(PrincetonReviewGreatSchoolInPopularMajorId id) {
		this.id = id;
	}

}