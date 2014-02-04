package com.bedrosians.bedlogic.domain.item;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SpecialHandleCode extends UnitInfo implements java.io.Serializable {
			
	@Column(name = "specialhandlecd1", length = 10)
	private String specialHandleCode1;
	@Column(name = "specialhandlecd2", length = 10)
	private String specialHandleCode2;
	@Column(name = "specialhandlecd3", length = 10)
	private String specialHandleCode3;

	public String getSpecialHandleCode1() {
		return specialHandleCode1;
	}

	public void setSpecialHandleCode1(String specialHandleCode1) {
		this.specialHandleCode1 = specialHandleCode1;
	}

	public String getSpecialHandleCode2() {
		return specialHandleCode2;
	}

	public void setSpecialHandleCode2(String specialHandleCode2) {
		this.specialHandleCode2 = specialHandleCode2;
	}

	public String getSpecialHandleCode3() {
		return specialHandleCode3;
	}

	public void setSpecialHandleCode3(String specialHandleCode3) {
		this.specialHandleCode3 = specialHandleCode3;
	}
	
	
}	
