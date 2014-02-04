package com.bedrosians.bedlogic.domain.item;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class UnitInfo implements java.io.Serializable {
	
	
	@Column(name = "unit1unit", length = 4)
	private String unit;
	@Column(name = "unit1isstdsell", length = 1)
	private Character isStandardSell;
	@Column(name = "unit1isstdord", length = 1)
	private Character isStandardOrder;
	@Column(name = "unit1isfractqty", length = 1)
	private Character isFractQuality;
	@Column(name = "unit1ispackunit", length = 1)
	private Character isPackUnit;
	@Column(name = "unit1upc", precision = 17, scale = 0)
	private Long upc;
	@Column(name = "unit1upcdesc", length = 15)
	private String upcDescription;
	@Column(name = "unit1wgtperunit", precision = 10, scale = 6)
	private BigDecimal weightPerUnit;
	
	@Column(name = "unit1ratio", precision = 9, scale = 4)
	private BigDecimal unitRatio;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Character getIsStandardSell() {
		return isStandardSell;
	}

	public void setIsStandardSell(Character isStandardSell) {
		this.isStandardSell = isStandardSell;
	}

	public Character getIsStandardOrder() {
		return isStandardOrder;
	}

	public void setIsStandardOrder(Character isStandardOrder) {
		this.isStandardOrder = isStandardOrder;
	}

	public Character getIsFractQuality() {
		return isFractQuality;
	}

	public void setIsFractQuality(Character isFractQuality) {
		this.isFractQuality = isFractQuality;
	}

	public Character getIsPackUnit() {
		return isPackUnit;
	}

	public void setIsPackUnit(Character isPackUnit) {
		this.isPackUnit = isPackUnit;
	}

	public Long getUpc() {
		return upc;
	}

	public void setUpc(Long upc) {
		this.upc = upc;
	}

	public String getUpcDescription() {
		return upcDescription;
	}

	public void setUpcDescription(String upcDescription) {
		this.upcDescription = upcDescription;
	}

	public BigDecimal getWeightPerUnit() {
		return weightPerUnit;
	}

	public void setWeightPerUnit(BigDecimal weightPerUnit) {
		this.weightPerUnit = weightPerUnit;
	}

	public BigDecimal getUnitRatio() {
		return unitRatio;
	}

	public void setUnitRatio(BigDecimal unitRatio) {
		this.unitRatio = unitRatio;
	}
	
		

	/* map tp ims_units
	@Column(name = "base", length = 4)
	private String unit;
	private BigDecimal unitRatio;
	@Column(name = "bstd", length = 1)
	private Character isStandardSell;
	@Column(name = "bfrct", length = 1)
	private Character isFractQuality;
	@Column(name = "bpu", length = 1)
	private Character isPackUnit;
	@Column(name = "baseupcdesc", length = 15)
	private String isPackUnitDescription;
	@Column(name = "basevolperunit", precision = 10, scale = 6)
	private BigDecimal baseVolumePerUnit;
	@Column(name = "basewgtperunit", precision = 10, scale = 6)
	private BigDecimal baseWeightPerUnit;
	*/	
	
	
}	
