package com.bedrosians.bedlogic.domain.item;
// Generated Jan 30, 2014 3:56:13 PM by Hibernate Tools 4.0.0


import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Miscellaneous extends Item implements java.io.Serializable {

	@Column(name = "origin", length = 18)
	private String origin;
	@Column(name = "shadevariation", length = 2)
	private String shadeVariation;
	@Column(name = "icons", length = 20)
	private String icons;
	@Column(name = "colorcategory", length = 30)
	private String colorCategory;
	@Column(name = "showonwebsite", length = 1)
	private Character showOnWebsite;
	@Column(name = "showonalysedwards", length = 1)
	private Character showonalysedwards;
	@Column(name = "offshade", length = 1)
	private Character offShade;	
	@Column(name = "samplenbr", precision = 8, scale = 0)
	private Integer sampleNo;
	@Column(name = "type", length = 16)
	private String type;
	@Column(name = "subtype", length = 32)
	private String subtype;
		

	public Miscellaneous() {
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getShadeVariation() {
		return shadeVariation;
	}


	public void setShadeVariation(String shadeVariation) {
		this.shadeVariation = shadeVariation;
	}

    public String getIcons() {
		return icons;
	}


	public void setIcons(String icons) {
		this.icons = icons;
	}


	public String getColorCategory() {
		return colorCategory;
	}


	public void setColorCategory(String colorCategory) {
		this.colorCategory = colorCategory;
	}


	public Character getShowOnWebsite() {
		return showOnWebsite;
	}


	public void setShowOnWebsite(Character showOnWebsite) {
		this.showOnWebsite = showOnWebsite;
	}


	public Character getShowonalysedwards() {
		return showonalysedwards;
	}


	public void setShowonalysedwards(Character showonalysedwards) {
		this.showonalysedwards = showonalysedwards;
	}


	public Character getOffShade() {
		return offShade;
	}


	public void setOffShade(Character offShade) {
		this.offShade = offShade;
	}


	public Integer getSampleNo() {
		return sampleNo;
	}


	public void setSampleNo(Integer sampleNo) {
		this.sampleNo = sampleNo;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSubtype() {
		return subtype;
	}


	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

    
}
