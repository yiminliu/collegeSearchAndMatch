package com.bedrosians.bedlogic.domain.item;
// Generated Jan 30, 2014 3:48:29 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Vendor implements java.io.Serializable {
	
	@Column(name = "vendornbr", precision = 6, scale = 0)
	private Integer vendorId;
	@Column(name = "vendornbr1", precision = 6, scale = 0)
	private Integer vendorId1;
	@Column(name = "vendornbr2", precision = 6, scale = 0)
	private Integer vendorId2;
	@Column(name = "vendornbr3", precision = 6, scale = 0)
	private Integer vendorId3;
	@Column(name = "vendorxrefcd", length = 30)
	private String vendorXRrefCode;	
	@Column(name = "vendorfob", length = 10)
	private String vendorFob;	
	@Column(name = "vendorlistprice", precision = 9, scale = 4)
	private BigDecimal vendorListPrice;		
	@Column(name = "vendornetprice", precision = 9, scale = 4)
	private BigDecimal vendorNetPrice;
	@Column(name = "vendormarkuppct", precision = 4, scale = 1)
	private BigDecimal vendorMarkupPercent;	
	@Column(name = "vendorpriceunit", length = 4)
	private String vendorPriceUnit;	
   	@Column(name = "vendordiscpct1", precision = 5)
	private BigDecimal vendorDiscountPercent1;
	@Column(name = "vendordiscpct2", precision = 5)
	private BigDecimal vendorDiscountPercent2;
	@Column(name = "vendordiscpct3", precision = 5)
	private BigDecimal vendorDiscountPercent3;
	@Column(name = "vendorroundaccuracy", precision = 1, scale = 0)
	private BigDecimal vendorRroundAccuracy;	
	@Column(name = "vendorfreightratecwt", precision = 9, scale = 4)
	private BigDecimal vendorFreightRateCwt;
	@Column(name = "vendorlandedbasecost", precision = 13, scale = 6)
	private BigDecimal vendorLandedBaseCost;
		
	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getVendorId1() {
		return vendorId1;
	}

	public void setVendorId1(Integer vendorId1) {
		this.vendorId1 = vendorId1;
	}

	public Integer getVendorId2() {
		return vendorId2;
	}

	public void setVendorId2(Integer vendorId2) {
		this.vendorId2 = vendorId2;
	}

	public Integer getVendorId3() {
		return vendorId3;
	}

	public void setVendorId3(Integer vendorId3) {
		this.vendorId3 = vendorId3;
	}

	public String getVendorXRrefCode() {
		return vendorXRrefCode;
	}

	public void setVendorXRrefCode(String vendorXRrefCode) {
		this.vendorXRrefCode = vendorXRrefCode;
	}

	public String getVendorFob() {
		return vendorFob;
	}

	public void setVendorFob(String vendorFob) {
		this.vendorFob = vendorFob;
	}

	public BigDecimal getVendorListPrice() {
		return vendorListPrice;
	}

	public void setVendorListPrice(BigDecimal vendorListPrice) {
		this.vendorListPrice = vendorListPrice;
	}

	public BigDecimal getVendorNetPrice() {
		return vendorNetPrice;
	}

	public void setVendorNetPrice(BigDecimal vendorNetPrice) {
		this.vendorNetPrice = vendorNetPrice;
	}

	public BigDecimal getVendorMarkupPercent() {
		return vendorMarkupPercent;
	}

	public void setVendorMarkupPercent(BigDecimal vendorMarkupPercent) {
		this.vendorMarkupPercent = vendorMarkupPercent;
	}

	public String getVendorPriceUnit() {
		return vendorPriceUnit;
	}

	public void setVendorPriceUnit(String vendorPriceUnit) {
		this.vendorPriceUnit = vendorPriceUnit;
	}

	public BigDecimal getVendorDiscountPercent1() {
		return vendorDiscountPercent1;
	}

	public void setVendorDiscountPercent1(BigDecimal vendorDiscountPercent1) {
		this.vendorDiscountPercent1 = vendorDiscountPercent1;
	}

	public BigDecimal getVendorDiscountPercent2() {
		return vendorDiscountPercent2;
	}

	public void setVendorDiscountPercent2(BigDecimal vendorDiscountPercent2) {
		this.vendorDiscountPercent2 = vendorDiscountPercent2;
	}

	public BigDecimal getVendorDiscountPercent3() {
		return vendorDiscountPercent3;
	}

	public void setVendorDiscountPercent3(BigDecimal vendorDiscountPercent3) {
		this.vendorDiscountPercent3 = vendorDiscountPercent3;
	}

	public BigDecimal getVendorRroundAccuracy() {
		return vendorRroundAccuracy;
	}

	public void setVendorRroundAccuracy(BigDecimal vendorRroundAccuracy) {
		this.vendorRroundAccuracy = vendorRroundAccuracy;
	}

	public BigDecimal getVendorFreightRateCwt() {
		return vendorFreightRateCwt;
	}

	public void setVendorFreightRateCwt(BigDecimal vendorFreightRateCwt) {
		this.vendorFreightRateCwt = vendorFreightRateCwt;
	}

	public BigDecimal getVendorLandedBaseCost() {
		return vendorLandedBaseCost;
	}

	public void setVendorLandedBaseCost(BigDecimal vendorLandedBaseCost) {
		this.vendorLandedBaseCost = vendorLandedBaseCost;
	}
	
	
}
