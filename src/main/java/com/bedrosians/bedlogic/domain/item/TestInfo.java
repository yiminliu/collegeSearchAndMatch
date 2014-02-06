package com.bedrosians.bedlogic.domain.item;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TestInfo {

	@Column(name = "water_absorption", precision = 4)
	private BigDecimal waterAbsorption;
	@Column(name = "scratch_resistance", precision = 5)
	private BigDecimal scratchResistance;
	@Column(name = "frost_resistance", length = 1)
	private Character frostResistance;
	@Column(name = "chemical_resistance", length = 1)
	private Character chemicalResistance;
	@Column(name = "pei_abrasion", precision = 4, scale = 1)
	private BigDecimal peiAbrasion;
	@Column(name = "sr_standard", length = 15)
	private String scratchStandard;
	@Column(name = "scof_wet", precision = 4)
	private BigDecimal scofWet;
	@Column(name = "scof_dry", precision = 4)
	private BigDecimal scofDry;
	@Column(name = "breaking_strength", precision = 5, scale = 0)
	private Integer breakingStrength;
	@Column(name = "bk_standard", length = 15)
	private String breakingStandard;
	@Column(name = "water_absorption_sign", length = 2)
	private String waterAbsorptionSign;
	@Column(name = "scof_wet_sign", length = 2)
	private String scofWetSign;
	@Column(name = "scof_dry_sign", length = 2)
	private String scofDrySign;
	@Column(name = "pre_consummer", precision = 5)
	private BigDecimal preConsummer;
	@Column(name = "pos_consummer", precision = 5)
	private BigDecimal posConsummer;
	@Column(name = "lead_point", length = 4)
	private String leadPoint;
	@Column(name = "dutypct", precision = 7, scale = 4)
	private BigDecimal dutyPercent;
	@Column(name = "restricted", length = 1)
	private Character restricted;
	@Column(name = "warpage", length = 1)
	private Character warpage;
	@Column(name = "wedging", length = 1)
	private Character wedging;
	@Column(name = "dcof", precision = 4, scale = 4)
	private BigDecimal dcof;
	@Column(name = "thermal_shock", length = 1)
	private Character thermalShock;
	@Column(name = "bond_strength", length = 6)
	private String bondStrength;
	@Column(name = "moh", precision = 5)
	private BigDecimal moh;
	@Column(name = "greenfriendly", length = 1)
	private Character greenFriendly;
	public BigDecimal getWaterAbsorption() {
		return waterAbsorption;
	}
	public void setWaterAbsorption(BigDecimal waterAbsorption) {
		this.waterAbsorption = waterAbsorption;
	}
	public BigDecimal getScratchResistance() {
		return scratchResistance;
	}
	public void setScratchResistance(BigDecimal scratchResistance) {
		this.scratchResistance = scratchResistance;
	}
	public Character getFrostResistance() {
		return frostResistance;
	}
	public void setFrostResistance(Character frostResistance) {
		this.frostResistance = frostResistance;
	}
	public Character getChemicalResistance() {
		return chemicalResistance;
	}
	public void setChemicalResistance(Character chemicalResistance) {
		this.chemicalResistance = chemicalResistance;
	}
	public BigDecimal getPeiAbrasion() {
		return peiAbrasion;
	}
	public void setPeiAbrasion(BigDecimal peiAbrasion) {
		this.peiAbrasion = peiAbrasion;
	}
	public String getScratchStandard() {
		return scratchStandard;
	}
	public void setScratchStandard(String scratchStandard) {
		this.scratchStandard = scratchStandard;
	}
	public BigDecimal getScofWet() {
		return scofWet;
	}
	public void setScofWet(BigDecimal scofWet) {
		this.scofWet = scofWet;
	}
	public BigDecimal getScofDry() {
		return scofDry;
	}
	public void setScofDry(BigDecimal scofDry) {
		this.scofDry = scofDry;
	}
	public Integer getBreakingStrength() {
		return breakingStrength;
	}
	public void setBreakingStrength(Integer breakingStrength) {
		this.breakingStrength = breakingStrength;
	}
	public String getBreakingStandard() {
		return breakingStandard;
	}
	public void setBreakingStandard(String breakingStandard) {
		this.breakingStandard = breakingStandard;
	}
	public String getWaterAbsorptionSign() {
		return waterAbsorptionSign;
	}
	public void setWaterAbsorptionSign(String waterAbsorptionSign) {
		this.waterAbsorptionSign = waterAbsorptionSign;
	}
	public String getScofWetSign() {
		return scofWetSign;
	}
	public void setScofWetSign(String scofWetSign) {
		this.scofWetSign = scofWetSign;
	}
	public String getScofDrySign() {
		return scofDrySign;
	}
	public void setScofDrySign(String scofDrySign) {
		this.scofDrySign = scofDrySign;
	}
	public BigDecimal getPreConsummer() {
		return preConsummer;
	}
	public void setPreConsummer(BigDecimal preConsummer) {
		this.preConsummer = preConsummer;
	}
	public BigDecimal getPosConsummer() {
		return posConsummer;
	}
	public void setPosConsummer(BigDecimal posConsummer) {
		this.posConsummer = posConsummer;
	}
	public String getLeadPoint() {
		return leadPoint;
	}
	public void setLeadPoint(String leadPoint) {
		this.leadPoint = leadPoint;
	}
	public BigDecimal getDutyPercent() {
		return dutyPercent;
	}
	public void setDutyPercent(BigDecimal dutyPercent) {
		this.dutyPercent = dutyPercent;
	}
	public Character getRestricted() {
		return restricted;
	}
	public void setRestricted(Character restricted) {
		this.restricted = restricted;
	}
	public Character getWarpage() {
		return warpage;
	}
	public void setWarpage(Character warpage) {
		this.warpage = warpage;
	}
	public Character getWedging() {
		return wedging;
	}
	public void setWedging(Character wedging) {
		this.wedging = wedging;
	}
	public BigDecimal getDcof() {
		return dcof;
	}
	public void setDcof(BigDecimal dcof) {
		this.dcof = dcof;
	}
	public Character getThermalShock() {
		return thermalShock;
	}
	public void setThermalShock(Character thermalShock) {
		this.thermalShock = thermalShock;
	}
	public String getBondStrength() {
		return bondStrength;
	}
	public void setBondStrength(String bondStrength) {
		this.bondStrength = bondStrength;
	}
	public BigDecimal getMoh() {
		return moh;
	}
	public void setMoh(BigDecimal moh) {
		this.moh = moh;
	}
	public Character getGreenFriendly() {
		return greenFriendly;
	}
	public void setGreenFriendly(Character greenFriendly) {
		this.greenFriendly = greenFriendly;
	}	
		
	
}
