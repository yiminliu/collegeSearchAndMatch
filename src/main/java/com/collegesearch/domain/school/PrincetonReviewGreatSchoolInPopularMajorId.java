package com.collegesearch.domain.school;

// Generated Aug 10, 2015 3:42:22 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrincetonReviewGreatSchoolMajorId generated by hbm2java
 */
@Embeddable
public class PrincetonReviewGreatSchoolInPopularMajorId implements java.io.Serializable {

	private static final long serialVersionUID = 674999895470L;
	private int schoolId;
	private int majorId;

	public PrincetonReviewGreatSchoolInPopularMajorId() {
	}

	public PrincetonReviewGreatSchoolInPopularMajorId(int schoolId, int majorId) {
		this.schoolId = schoolId;
		this.majorId = majorId;
	}

	@Column(name = "School_Id", nullable = false)
	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name = "Major_Id", nullable = false)
	public int getMajorId() {
		return this.majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrincetonReviewGreatSchoolInPopularMajorId))
			return false;
		PrincetonReviewGreatSchoolInPopularMajorId castOther = (PrincetonReviewGreatSchoolInPopularMajorId) other;

		return (this.getSchoolId() == castOther.getSchoolId())
				&& (this.getMajorId() == castOther.getMajorId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSchoolId();
		result = 37 * result + this.getMajorId();
		return result;
	}

}