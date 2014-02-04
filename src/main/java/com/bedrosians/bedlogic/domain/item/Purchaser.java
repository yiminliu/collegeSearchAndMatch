package com.bedrosians.bedlogic.domain.item;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Purchaser implements java.io.Serializable {
			
	@Column(name = "purchaser", length = 10)
	private String purchaser1;
	@Column(name = "purchaser2", length = 10)
	private String purchaser2;
	
	public String getPurchaser1() {
		return purchaser1;
	}
	public void setPurchaser1(String purchaser1) {
		this.purchaser1 = purchaser1;
	}
	public String getPurchaser2() {
		return purchaser2;
	}
	public void setPurchaser2(String purchaser2) {
		this.purchaser2 = purchaser2;
	}
	
	
}	
