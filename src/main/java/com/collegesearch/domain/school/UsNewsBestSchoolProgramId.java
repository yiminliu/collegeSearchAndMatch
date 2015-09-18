package com.collegesearch.domain.school;

// Generated Aug 10, 2015 3:17:49 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsNewsBestSchoolProgramId generated by hbm2java
 */
@Embeddable
public class UsNewsBestSchoolProgramId implements java.io.Serializable {

	private static final long serialVersionUID = 835149990758703320L;
	
	private int schoolId;
	private int programId;

	public UsNewsBestSchoolProgramId() {
	}

	public UsNewsBestSchoolProgramId(int schoolId, int programId) {
		this.schoolId = schoolId;
		this.programId = programId;
	}

	@Column(name = "School_Id", nullable = false)
	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name = "Program_Id", nullable = false)
	public int getProgramId() {
		return this.programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsNewsBestSchoolProgramId))
			return false;
		UsNewsBestSchoolProgramId castOther = (UsNewsBestSchoolProgramId) other;

		return (this.getSchoolId() == castOther.getSchoolId())
				&& (this.getProgramId() == castOther.getProgramId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSchoolId();
		result = 37 * result + this.getProgramId();
		return result;
	}

}