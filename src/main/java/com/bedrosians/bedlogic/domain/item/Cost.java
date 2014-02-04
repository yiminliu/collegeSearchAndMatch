package com.bedrosians.bedlogic.domain.item;
// default package
// Generated Jan 30, 2014 3:48:29 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Cost implements java.io.Serializable {

	@Column(name = "cost1", precision = 9, scale = 4)
	private BigDecimal cost1;	
	@Column(name = "priorcost", precision = 9, scale = 4)
	private BigDecimal priorcost;
	@Column(name = "priorcost1", precision = 9, scale = 4)
	private BigDecimal priorcost1;	
	@Column(name = "futurecost", precision = 9, scale = 4)
	private BigDecimal futurecost;	
	@Column(name = "futurecost1", precision = 9, scale = 4)
	private BigDecimal futurecost1;	
	//@Column(name = "vendorfreightratecwt", precision = 9, scale = 4)
	//private BigDecimal vendorFreightRateCwt;
	//@Column(name = "vendorlandedbasecost", precision = 13, scale = 6)
	//private BigDecimal vendorLandedBaseCost;
	//@Column(name = "priorvendorfreightratecwt", precision = 9, scale = 4)	
	//private BigDecimal priorVendorFreightRateCwt;
	//@Column(name = "priorvendorlandedbasecost", precision = 13, scale = 6)
	//private BigDecimal priorVendorLandedBaseCost;
	@Column(name = "costrangepct", precision = 4, scale = 1)
	private BigDecimal costRangePercent;
	@Column(name = "poincludeinvendorcost", precision = 4, scale = 1)
	private Character poIncludeInVendorCost;
	public BigDecimal getCost1() {
		return cost1;
	}
	public void setCost1(BigDecimal cost1) {
		this.cost1 = cost1;
	}
	public BigDecimal getPriorcost() {
		return priorcost;
	}
	public void setPriorcost(BigDecimal priorcost) {
		this.priorcost = priorcost;
	}
	public BigDecimal getPriorcost1() {
		return priorcost1;
	}
	public void setPriorcost1(BigDecimal priorcost1) {
		this.priorcost1 = priorcost1;
	}
	public BigDecimal getFuturecost() {
		return futurecost;
	}
	public void setFuturecost(BigDecimal futurecost) {
		this.futurecost = futurecost;
	}
	public BigDecimal getFuturecost1() {
		return futurecost1;
	}
	public void setFuturecost1(BigDecimal futurecost1) {
		this.futurecost1 = futurecost1;
	}	
	
	public BigDecimal getCostRangePercent() {
		return costRangePercent;
	}
	public void setCostRangePercent(BigDecimal costRangePercent) {
		this.costRangePercent = costRangePercent;
	}
	public Character getPoIncludeInVendorCost() {
		return poIncludeInVendorCost;
	}
	public void setPoIncludeInVendorCost(Character poIncludeInVendorCost) {
		this.poIncludeInVendorCost = poIncludeInVendorCost;
	}		
	
}
