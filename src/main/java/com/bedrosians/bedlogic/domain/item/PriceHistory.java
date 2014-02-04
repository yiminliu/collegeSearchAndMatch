package com.bedrosians.bedlogic.domain.item;
// default package
// Generated Jan 30, 2014 3:48:29 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class PriceHistory implements java.io.Serializable {

	@Column(name = "priorlistprice", precision = 9, scale = 4)
	private BigDecimal priorListPrice;
	@Column(name = "priorsellprice", precision = 9, scale = 4)
	private BigDecimal priorSellPrice;
		
	public PriceHistory() {
	}

	public BigDecimal getPriorListPrice() {
		return priorListPrice;
	}

	public void setPriorListPrice(BigDecimal priorListPrice) {
		this.priorListPrice = priorListPrice;
	}

	public BigDecimal getPriorSellPrice() {
		return priorSellPrice;
	}

	public void setPriorSellPrice(BigDecimal priorSellPrice) {
		this.priorSellPrice = priorSellPrice;
	}
	
}
