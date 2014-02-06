package com.bedrosians.bedlogic.domain.item;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PriorVendor implements java.io.Serializable {
	
	@Column(name = "priorvendorpriceunit", length = 4)
	private String priorVendorPriceUnit;	
	@Column(name = "priorvendorfob", length = 10)
	private String priorVendorFob;	
	@Column(name = "priorvendorlistprice", precision = 9, scale = 4)
	private BigDecimal priorVendorListPrice;	
	@Column(name = "priorvendordiscpct1", precision = 5)
	private BigDecimal priorVendorDiscountPercent1;
	@Column(name = "priorvendordiscpct2", precision = 5)
	private BigDecimal priorVendorDiscountPercent2;
	@Column(name = "priorvendordiscpct3", precision = 5)
	private BigDecimal priorVendorDiscountPercent3;
	@Column(name = "priorvendorroundaccuracy", precision = 1, scale = 0)
	private BigDecimal priorVendorRoundAccuracy;
	@Column(name = "priorvendornetprice", precision = 9, scale = 4)
	private BigDecimal priorVendorNetPrice;
	@Column(name = "priorvendormarkuppct", precision = 4, scale = 1)
	private BigDecimal priorVendorMarkupPercent;
		
	public BigDecimal getPriorVendorListPrice() {
		return priorVendorListPrice;
	}

	public void setPriorVendorListPrice(BigDecimal priorVendorListPrice) {
		this.priorVendorListPrice = priorVendorListPrice;
	}

	public String getPriorVendorPriceUnit() {
		return priorVendorPriceUnit;
	}

	public void setPriorVendorPriceUnit(String priorVendorPriceUnit) {
		this.priorVendorPriceUnit = priorVendorPriceUnit;
	}

	public String getPriorVendorFob() {
		return priorVendorFob;
	}

	public void setPriorVendorFob(String priorVendorFob) {
		this.priorVendorFob = priorVendorFob;
	}

	public BigDecimal getPriorVendorDiscountPercent1() {
		return priorVendorDiscountPercent1;
	}

	public void setPriorVendorDiscountPercent1(
			BigDecimal priorVendorDiscountPercent1) {
		this.priorVendorDiscountPercent1 = priorVendorDiscountPercent1;
	}

	public BigDecimal getPriorVendorDiscountPercent2() {
		return priorVendorDiscountPercent2;
	}

	public void setPriorVendorDiscountPercent2(
			BigDecimal priorVendorDiscountPercent2) {
		this.priorVendorDiscountPercent2 = priorVendorDiscountPercent2;
	}

	public BigDecimal getPriorVendorDiscountPercent3() {
		return priorVendorDiscountPercent3;
	}

	public void setPriorVendorDiscountPercent3(
			BigDecimal priorVendorDiscountPercent3) {
		this.priorVendorDiscountPercent3 = priorVendorDiscountPercent3;
	}

	public BigDecimal getPriorVendorRoundAccuracy() {
		return priorVendorRoundAccuracy;
	}

	public void setPriorVendorRoundAccuracy(BigDecimal priorVendorRoundAccuracy) {
		this.priorVendorRoundAccuracy = priorVendorRoundAccuracy;
	}

	public BigDecimal getPriorVendorNetPrice() {
		return priorVendorNetPrice;
	}

	public void setPriorVendorNetPrice(BigDecimal priorVendorNetPrice) {
		this.priorVendorNetPrice = priorVendorNetPrice;
	}

	public BigDecimal getPriorVendorMarkupPercent() {
		return priorVendorMarkupPercent;
	}

	public void setPriorVendorMarkupPercent(BigDecimal priorVendorMarkupPercent) {
		this.priorVendorMarkupPercent = priorVendorMarkupPercent;
	}	
	
}
