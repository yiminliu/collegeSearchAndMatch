package com.bedrosians.bedlogic.domain.item;
// default package
// Generated Jan 30, 2014 3:48:29 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Prices implements java.io.Serializable {

	@Column(name = "price", length = 1)
	private BigDecimal price;	
		
	/* List Prices */
	@Column(name = "listprice", precision = 9, scale = 4)
	private BigDecimal listPrice;	
	@Column(name = "listprice1", precision = 9, scale = 4)
	private BigDecimal listPrice1;	//listprice(fl)
	@Column(name = "listprice2", precision = 9, scale = 4)
	private BigDecimal listPrice2;	
	@Column(name = "listprice3", precision = 9, scale = 4)
	private BigDecimal listPrice3;	
	@Column(name = "listprice4", precision = 9, scale = 4)
	private BigDecimal listPrice4;	
	@Column(name = "listprice5", precision = 9, scale = 4)
	private BigDecimal listPrice5;	
		
	/* Sell Prices */
	@Column(name = "sellprice", precision = 9, scale = 4)
	private BigDecimal sellPrice;	
	@Column(name = "sellprice1", precision = 9, scale = 4)
	private BigDecimal sellPrice1;	
	@Column(name = "sellprice2", precision = 9, scale = 4)
	private BigDecimal sellPrice2;	
	@Column(name = "sellprice3", precision = 9, scale = 4)
	private BigDecimal sellPrice3;	
	@Column(name = "sellprice4", precision = 9, scale = 4)
	private BigDecimal sellPrice4;	
	@Column(name = "sellprice5", precision = 9, scale = 4)
	private BigDecimal sellPrice5;	
	
	@Column(name = "priorlastupdated", length = 13)
	private Date priorlastupdated;	
	
	/* Temporary Prices */
	@Column(name = "tempprice", precision = 9, scale = 4)
	private BigDecimal temporaryPrice;
	@Temporal(TemporalType.DATE)
	@Column(name = "tempdatefrom", length = 13)
	private Date temporaryPriceDateFrom;
	@Temporal(TemporalType.DATE)
	@Column(name = "tempdatethru", length = 13)
	private Date temporaryPriceDateTo;
	
	/* Future Prices */
	@Column(name = "futurelist", precision = 9, scale = 4)
	private BigDecimal futureListPrice;
	@Column(name = "futurelist1", precision = 9, scale = 4)
	private BigDecimal futureListPrice1;	
	@Column(name = "futuresell", precision = 9, scale = 4)
	private BigDecimal futureSellPrice;
	@Column(name = "futuresell1", precision = 9, scale = 4)
	private BigDecimal futureSellPrice1;
		
	/* Price Calculations */
	@Column(name = "listpricemarginpct", precision = 5)
	private BigDecimal listPriceMarginPercent;	
	
	@Column(name = "sellpricemarginpct", precision = 5)
	private BigDecimal sellPriceMarginPercent;	
	@Column(name = "sellpriceroundaccuracy", precision = 1, scale = 0)
	private BigDecimal sellPriceRoundAccuracy;
	
	@Column(name = "calcsellprice", precision = 9, scale = 4)
	private BigDecimal calcSellPrice;	
	@Column(name = "calclistprice", precision = 9, scale = 4)
	private BigDecimal calcListPrice;
	
	/* price group */
	@Column(name = "pricegroup", length = 2)
	private String priceGroup;	
	
	@Embedded
	PriceHistory priceHistory;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="priorListPrice", column=@Column(name="priorlistprice1")),
		@AttributeOverride(name="priorSellPrice", column=@Column(name="priorsellprice1"))
	})
	PriceHistory priceHistory1;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="priorListPrice", column=@Column(name="priorlistprice2")),
		@AttributeOverride(name="priorSellPrice", column=@Column(name="priorsellprice2"))
	})
	PriceHistory priceHistory2;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="priorListPrice", column=@Column(name="priorlistprice3")),
		@AttributeOverride(name="priorSellPrice", column=@Column(name="priorsellprice3"))	
	})
	PriceHistory priceHistory3;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="priorListPrice", column=@Column(name="priorlistprice4")),
		@AttributeOverride(name="priorSellPrice", column=@Column(name="priorsellprice4"))
	})
	PriceHistory priceHistory4;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceGroup() {
		return priceGroup;
	}

	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getListPrice1() {
		return listPrice1;
	}

	public void setListPrice1(BigDecimal listPrice1) {
		this.listPrice1 = listPrice1;
	}

	public BigDecimal getListPrice2() {
		return listPrice2;
	}

	public void setListPrice2(BigDecimal listPrice2) {
		this.listPrice2 = listPrice2;
	}

	public BigDecimal getListPrice3() {
		return listPrice3;
	}

	public void setListPrice3(BigDecimal listPrice3) {
		this.listPrice3 = listPrice3;
	}

	public BigDecimal getListPrice4() {
		return listPrice4;
	}

	public void setListPrice4(BigDecimal listPrice4) {
		this.listPrice4 = listPrice4;
	}

	public BigDecimal getListPrice5() {
		return listPrice5;
	}

	public void setListPrice5(BigDecimal listPrice5) {
		this.listPrice5 = listPrice5;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public BigDecimal getSellPrice1() {
		return sellPrice1;
	}

	public void setSellPrice1(BigDecimal sellPrice1) {
		this.sellPrice1 = sellPrice1;
	}

	public BigDecimal getSellPrice2() {
		return sellPrice2;
	}

	public void setSellPrice2(BigDecimal sellPrice2) {
		this.sellPrice2 = sellPrice2;
	}

	public BigDecimal getSellPrice3() {
		return sellPrice3;
	}

	public void setSellPrice3(BigDecimal sellPrice3) {
		this.sellPrice3 = sellPrice3;
	}

	public BigDecimal getSellPrice4() {
		return sellPrice4;
	}

	public void setSellPrice4(BigDecimal sellPrice4) {
		this.sellPrice4 = sellPrice4;
	}

	public BigDecimal getSellPrice5() {
		return sellPrice5;
	}

	public void setSellPrice5(BigDecimal sellPrice5) {
		this.sellPrice5 = sellPrice5;
	}

	public BigDecimal getFutureListPrice() {
		return futureListPrice;
	}

	public void setFutureListPrice(BigDecimal futureListPrice) {
		this.futureListPrice = futureListPrice;
	}

	public BigDecimal getFutureListPrice1() {
		return futureListPrice1;
	}

	public void setFutureListPrice1(BigDecimal futureListPrice1) {
		this.futureListPrice1 = futureListPrice1;
	}

	public BigDecimal getFutureSellPrice() {
		return futureSellPrice;
	}

	public void setFutureSellPrice(BigDecimal futureSellPrice) {
		this.futureSellPrice = futureSellPrice;
	}

	public BigDecimal getFutureSellPrice1() {
		return futureSellPrice1;
	}

	public void setFutureSellPrice1(BigDecimal futureSellPrice1) {
		this.futureSellPrice1 = futureSellPrice1;
	}

	public BigDecimal getTemporaryPrice() {
		return temporaryPrice;
	}

	public void setTemporaryPrice(BigDecimal temporaryPrice) {
		this.temporaryPrice = temporaryPrice;
	}

	public Date getTemporaryPriceDateFrom() {
		return temporaryPriceDateFrom;
	}

	public void setTemporaryPriceDateFrom(Date temporaryPriceDateFrom) {
		this.temporaryPriceDateFrom = temporaryPriceDateFrom;
	}

	public Date getTemporaryPriceDateTo() {
		return temporaryPriceDateTo;
	}

	public void setTemporaryPriceDateTo(Date temporaryPriceDateTo) {
		this.temporaryPriceDateTo = temporaryPriceDateTo;
	}

	public BigDecimal getListPriceMarginPercent() {
		return listPriceMarginPercent;
	}

	public void setListPriceMarginPercent(BigDecimal listPriceMarginPercent) {
		this.listPriceMarginPercent = listPriceMarginPercent;
	}
	
	public BigDecimal getSellPriceMarginPercent() {
		return sellPriceMarginPercent;
	}

	public void setSellPriceMarginPercent(BigDecimal sellPriceMarginPercent) {
		this.sellPriceMarginPercent = sellPriceMarginPercent;
	}

	public BigDecimal getSellPriceRoundAccuracy() {
		return sellPriceRoundAccuracy;
	}

	public void setSellPriceRoundAccuracy(BigDecimal sellPriceRoundAccuracy) {
		this.sellPriceRoundAccuracy = sellPriceRoundAccuracy;
	}

	public BigDecimal getCalcSellPrice() {
		return calcSellPrice;
	}

	public void setCalcSellPrice(BigDecimal calcSellPrice) {
		this.calcSellPrice = calcSellPrice;
	}

	public BigDecimal getCalcListPrice() {
		return calcListPrice;
	}

	public void setCalcListPrice(BigDecimal calcListPrice) {
		this.calcListPrice = calcListPrice;
	}

	public PriceHistory getPriceHistory() {
		return priceHistory;
	}

	public void setPriceHistory(PriceHistory priceHistory) {
		this.priceHistory = priceHistory;
	}

	public PriceHistory getPriceHistory1() {
		return priceHistory1;
	}

	public void setPriceHistory1(PriceHistory priceHistory1) {
		this.priceHistory1 = priceHistory1;
	}

	public PriceHistory getPriceHistory2() {
		return priceHistory2;
	}

	public void setPriceHistory2(PriceHistory priceHistory2) {
		this.priceHistory2 = priceHistory2;
	}

	public PriceHistory getPriceHistory3() {
		return priceHistory3;
	}

	public void setPriceHistory3(PriceHistory priceHistory3) {
		this.priceHistory3 = priceHistory3;
	}

	public PriceHistory getPriceHistory4() {
		return priceHistory4;
	}

	public void setPriceHistory4(PriceHistory priceHistory4) {
		this.priceHistory4 = priceHistory4;
	}	
	
	
}
