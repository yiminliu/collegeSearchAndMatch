package com.bedrosians.bedlogic.domain.item;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable
public class Units implements java.io.Serializable {

	
	@Column(name = "baseunit", length = 4)
	private String baseUnit;
	@Column(name = "baseisstdsell", length = 1)
	private Character baseIsStandardSell;
	@Column(name = "baseisstdord", length = 1)
	private Character baseIsStandardOrder;
	@Column(name = "baseisfractqty", length = 1)
	private Character baseIsFractQuality;
	@Column(name = "baseispackunit", length = 1)
	private Character baseIsPackUnit;
	@Column(name = "baseupc", precision = 17, scale = 0)
	private Long baseUpc;
	@Column(name = "baseupcdesc", length = 15)
	private String baseUpcDescription;
	@Column(name = "basevolperunit", precision = 10, scale = 6)
	private BigDecimal baseVolumePerUnit;
	@Column(name = "basewgtperunit", precision = 10, scale = 6)
	private BigDecimal baseWeightPerUnit;
	
	@Embedded
	/*@AttributeOverrides({
		@AttributeOverride(name="unit", column=@Column(name="unit1unit")),
		@AttributeOverride(name="unitRatio", column=@Column(name="unit1ratio")),
		@AttributeOverride(name="isStandardSell", column=@Column(name="unit1isstdsell")),
		@AttributeOverride(name="isStandardOrder", column=@Column(name="unit1isstdord")),
		@AttributeOverride(name="isFractQuality", column=@Column(name="unit1isfractqty")),
		@AttributeOverride(name="isPackUnit", column=@Column(name="unit1ispackunit")),
		@AttributeOverride(name="upc", column=@Column(name="unit1upc")),
		@AttributeOverride(name="upcDescription", column=@Column(name="unit1upcdesc")),
		@AttributeOverride(name="volumePerUnit", column=@Column(name="unit1volperunit")),
		@AttributeOverride(name="weightPerUnit", column=@Column(name="unit1wgtperunit"))
		
	})*/
	private UnitInfo unit1;
	
		
		
	@Embedded
	@AttributeOverrides({
		/*@AttributeOverride(name="unit", column=@Column(name="unit2")),
		@AttributeOverride(name="unitRatio", column=@Column(name="u2rat")),
		@AttributeOverride(name="isStandardSell", column=@Column(name="u2std")),
		@AttributeOverride(name="isFractQuality", column=@Column(name="u2frct")),
		@AttributeOverride(name="isPackUnitInfo", column=@Column(name="u2pu")),
		@AttributeOverride(name="isPackUnitInfoDescription", column=@Column(name="unit2upcdesc"))
		*/
		@AttributeOverride(name="unit", column=@Column(name="unit2unit")),
		@AttributeOverride(name="unitRatio", column=@Column(name="unit2ratio")),
		@AttributeOverride(name="isStandardSell", column=@Column(name="unit2isstdsell")),
		@AttributeOverride(name="isStandardOrder", column=@Column(name="unit2isstdord")),
		@AttributeOverride(name="isFractQuality", column=@Column(name="unit2isfractqty")),
		@AttributeOverride(name="isPackUnit", column=@Column(name="unit2ispackunit")),
		@AttributeOverride(name="upc", column=@Column(name="unit2upc")),
		@AttributeOverride(name="upcDescription", column=@Column(name="unit2upcdesc")),	
		@AttributeOverride(name="volumePerUnit", column=@Column(name="unit2volperunit")),
		@AttributeOverride(name="weightPerUnit", column=@Column(name="unit2wgtperunit"))
	})
	private UnitInfo unit2;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="unit", column=@Column(name="unit3unit")),
		@AttributeOverride(name="unitRatio", column=@Column(name="unit3ratio")),
		@AttributeOverride(name="isStandardSell", column=@Column(name="unit3isstdsell")),
		@AttributeOverride(name="isStandardOrder", column=@Column(name="unit3isstdord")),
		@AttributeOverride(name="isFractQuality", column=@Column(name="unit3isfractqty")),
		@AttributeOverride(name="isPackUnit", column=@Column(name="unit3ispackunit")),
		@AttributeOverride(name="upc", column=@Column(name="unit3upc")),
		@AttributeOverride(name="upcDescription", column=@Column(name="unit3upcdesc")),
		@AttributeOverride(name="volumePerUnit", column=@Column(name="unit3volperunit")),
		@AttributeOverride(name="weightPerUnit", column=@Column(name="unit3wgtperunit"))
	})
	private UnitInfo unit3;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="unit", column=@Column(name="unit4unit")),
		@AttributeOverride(name="unitRatio", column=@Column(name="unit4ratio")),
		@AttributeOverride(name="isStandardSell", column=@Column(name="unit4isstdsell")),
		@AttributeOverride(name="isStandardOrder", column=@Column(name="unit4isstdord")),
		@AttributeOverride(name="isFractQuality", column=@Column(name="unit4isfractqty")),
		@AttributeOverride(name="isPackUnit", column=@Column(name="unit4ispackunit")),
		@AttributeOverride(name="upc", column=@Column(name="unit4upc")),
		@AttributeOverride(name="upcDescription", column=@Column(name="unit4upcdesc")),
		@AttributeOverride(name="volumePerUnit", column=@Column(name="unit4volperunit")),
		@AttributeOverride(name="weightPerUnit", column=@Column(name="unit4wgtperunit"))
	})
	private UnitInfo unit4;

	public String getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	public Character getBaseIsStandardSell() {
		return baseIsStandardSell;
	}

	public void setBaseIsStandardSell(Character baseIsStandardSell) {
		this.baseIsStandardSell = baseIsStandardSell;
	}

	public Character getBaseIsStandardOrder() {
		return baseIsStandardOrder;
	}

	public void setBaseIsStandardOrder(Character baseIsStandardOrder) {
		this.baseIsStandardOrder = baseIsStandardOrder;
	}

	public Character getBaseIsFractQuality() {
		return baseIsFractQuality;
	}

	public void setBaseIsFractQuality(Character baseIsFractQuality) {
		this.baseIsFractQuality = baseIsFractQuality;
	}

	public Character getBaseIsPackUnit() {
		return baseIsPackUnit;
	}

	public void setBaseIsPackUnit(Character baseIsPackUnit) {
		this.baseIsPackUnit = baseIsPackUnit;
	}

	public Long getBaseUpc() {
		return baseUpc;
	}

	public void setBaseUpc(Long baseUpc) {
		this.baseUpc = baseUpc;
	}

	public String getBaseUpcDescription() {
		return baseUpcDescription;
	}

	public void setBaseUpcDescription(String baseUpcDescription) {
		this.baseUpcDescription = baseUpcDescription;
	}

	public BigDecimal getBaseVolumePerUnit() {
		return baseVolumePerUnit;
	}

	public void setBaseVolumePerUnit(BigDecimal baseVolumePerUnit) {
		this.baseVolumePerUnit = baseVolumePerUnit;
	}

	public BigDecimal getBaseWeightPerUnit() {
		return baseWeightPerUnit;
	}

	public void setBaseWeightPerUnit(BigDecimal baseWeightPerUnit) {
		this.baseWeightPerUnit = baseWeightPerUnit;
	}

	public UnitInfo getUnit1() {
		return unit1;
	}

	public void setUnit1(UnitInfo unit1) {
		this.unit1 = unit1;
	}

	public UnitInfo getUnit2() {
		return unit2;
	}

	public void setUnit2(UnitInfo unit2) {
		this.unit2 = unit2;
	}

	public UnitInfo getUnit3() {
		return unit3;
	}

	public void setUnit3(UnitInfo unit3) {
		this.unit3 = unit3;
	}

	public UnitInfo getUnit4() {
		return unit4;
	}

	public void setUnit4(UnitInfo unit4) {
		this.unit4 = unit4;
	}
		
	
	
}	
