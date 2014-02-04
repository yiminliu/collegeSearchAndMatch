package com.bedrosians.bedlogic.domain.item;
// Generated Jan 30, 2014 3:56:13 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.bedrosians.bedlogic.util.FormatUtil;

@MappedSuperclass
public class Item implements java.io.Serializable {

	@Id
	@Column(name = "itemcd", unique = true, nullable = false)
	private String itemId;	
	@Column(name = "abccd", length = 4)
	private String abcCode;
	@Column(name = "itemcd2", length = 18)
	private String itemId2;
	@Column(name = "itemdesc1", length = 35)
	private String itemDescription1;
	@Column(name = "itemdesc2", length = 35)
	private String itemDescription2;
	@Column(name = "fulldesc", length = 70)
	private String fullDescription;
	@Column(name = "color", length = 30)
	private String color;
	@Column(name = "seriesname", length = 40)
	private String seriesName;
	@Column(name = "inventory_itemcd", length = 18)
	private String inventoryItemId;
	@Column(name = "updatecd", length = 10)
	private String updateCode;
	@Column(name = "itemtypecd", length = 1)
	private Character itemTypeCode;	
	@Column(name = "category", length = 8)
	private String category;
	@Column(name = "inactivecd", length = 3)
	private String status;
	@Column(name = "lottype", length = 1)
	private Character lotType;
	@Column(name = "itemtaxclass", length = 1)
	private Character itemTaxClass;	
	@Column(name = "nonstockcostpct", precision = 4, scale = 1)
	private BigDecimal nonStockCostPercent;
	@Column(name = "length", length = 12)
	private String actualLength;
	@Column(name = "width", length = 12)
	private String actualWidth;
	@Column(name = "nm_length", precision = 5)
	private BigDecimal norminalLength;
	@Column(name = "nm_width", precision = 5)
	private BigDecimal norminalWidth;
	@Column(name = "nm_thickness", precision = 5)
	private BigDecimal norminalThickness;
	@Column(name = "minmarginpct", precision = 4, scale = 1)
	private BigDecimal minMarginPercent;
	@Column(name = "thickness", length = 12)
	private String thickness;
	@Column(name = "thicknessunit", length = 3)
	private String thicknessUnit;
	@Column(name = "sizeunits", length = 3)
	private String sizeUnits;	
	
	@Embedded
	private Purchaser purchaser;
	
	@Column(name = "mattype", length = 24)
	private String materialType;
	@Column(name = "materialclass_cd", length = 5)
	private String materialClassCode;
	@Column(name = "matcategory", length = 10)
	private String materialCategory;
	@Column(name = "matstyle", length = 7)
	private String materialStyle;
	@Column(name = "mfeature", length = 15)
	private String materialFeature;
	@Column(name = "qualitychoice", length = 12)
	private String qualityChoice;
			
	public Item() {
	}

	public String getItemId() {
		return FormatUtil.process(itemId);
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAbcCode() {
		return abcCode;
	}

	public void setAbcCode(String abcCode) {
		this.abcCode = abcCode;
	}

	public String getItemId2() {
		return itemId2;
	}

	public void setItemId2(String itemId2) {
		this.itemId2 = itemId2;
	}

	public String getItemDescription1() {
		return itemDescription1;
	}

	public void setItemDescription1(String itemDescription1) {
		this.itemDescription1 = itemDescription1;
	}

	public String getItemDescription2() {
		return itemDescription2;
	}

	public void setItemDescription2(String itemDescription2) {
		this.itemDescription2 = itemDescription2;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(String inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public String getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}

	public Character getItemTypeCode() {
		return itemTypeCode;
	}

	public void setItemTypeCode(Character itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Character getLotType() {
		return lotType;
	}

	public void setLotType(Character lotType) {
		this.lotType = lotType;
	}

	public Character getItemTaxClass() {
		return itemTaxClass;
	}

	public void setItemTaxClass(Character itemTaxClass) {
		this.itemTaxClass = itemTaxClass;
	}

	public BigDecimal getNonStockCostPercent() {
		return nonStockCostPercent;
	}

	public void setNonStockCostPercent(BigDecimal nonStockCostPercent) {
		this.nonStockCostPercent = nonStockCostPercent;
	}

	public String getActualLength() {
		return actualLength;
	}

	public void setActualLength(String actualLength) {
		this.actualLength = actualLength;
	}

	public String getActualWidth() {
		return actualWidth;
	}

	public void setActualWidth(String actualWidth) {
		this.actualWidth = actualWidth;
	}

	public BigDecimal getNorminalLength() {
		return norminalLength;
	}

	public void setNorminalLength(BigDecimal norminalLength) {
		this.norminalLength = norminalLength;
	}

	public BigDecimal getNorminalWidth() {
		return norminalWidth;
	}

	public void setNorminalWidth(BigDecimal norminalWidth) {
		this.norminalWidth = norminalWidth;
	}

	public BigDecimal getNorminalThickness() {
		return norminalThickness;
	}

	public void setNorminalThickness(BigDecimal norminalThickness) {
		this.norminalThickness = norminalThickness;
	}

	public BigDecimal getMinMarginPercent() {
		return minMarginPercent;
	}

	public void setMinMarginPercent(BigDecimal minMarginPercent) {
		this.minMarginPercent = minMarginPercent;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	
	public String getThicknessUnit() {
		return thicknessUnit;
	}

	public void setThicknessUnit(String thicknessUnit) {
		this.thicknessUnit = thicknessUnit;
	}

	public String getSizeUnits() {
		return sizeUnits;
	}

	public void setSizeUnits(String sizeUnits) {
		this.sizeUnits = sizeUnits;
	}

	public Purchaser getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialClassCode() {
		return materialClassCode;
	}

	public void setMaterialClassCode(String materialClassCode) {
		this.materialClassCode = materialClassCode;
	}

	public String getMaterialCategory() {
		return materialCategory;
	}

	public void setMaterialCategory(String materialCategory) {
		this.materialCategory = materialCategory;
	}

	public String getMaterialStyle() {
		return materialStyle;
	}

	public void setMaterialStyle(String materialStyle) {
		this.materialStyle = materialStyle;
	}

	public String getMaterialFeature() {
		return materialFeature;
	}

	public void setMaterialFeature(String materialFeature) {
		this.materialFeature = materialFeature;
	}

	public String getQualityChoice() {
		return qualityChoice;
	}

	public void setQualityChoice(String qualityChoice) {
		this.qualityChoice = qualityChoice;
	}
		
	
}
