package com.bedrosians.bedlogic.domain.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Alias extends UnitInfo implements java.io.Serializable {
			
	@Column(name = "known_aliases1", length = 30)
	private String knownAliases1;
	@Column(name = "known_aliases2", length = 30)
	private String knownAliases2;	
	@Column(name = "known_aliases3", length = 30)
	private String knownAliases3;
	@Column(name = "known_aliases4", length = 30)
	private String knownAliases4;
	@Column(name = "known_aliases5", length = 30)
	private String knownAliases5;
	@Column(name = "known_aliases6", length = 30)
	private String knownAliases6;
	@Column(name = "known_aliases7", length = 30)
	private String knownAliases7;
	
	
	public String getKnownAliases1() {
		return knownAliases1;
	}
	public void setKnownAliases1(String knownAliases1) {
		this.knownAliases1 = knownAliases1;
	}
	public String getKnownAliases2() {
		return knownAliases2;
	}
	public void setKnownAliases2(String knownAliases2) {
		this.knownAliases2 = knownAliases2;
	}
	public String getKnownAliases3() {
		return knownAliases3;
	}
	public void setKnownAliases3(String knownAliases3) {
		this.knownAliases3 = knownAliases3;
	}
	public String getKnownAliases4() {
		return knownAliases4;
	}
	public void setKnownAliases4(String knownAliases4) {
		this.knownAliases4 = knownAliases4;
	}
	public String getKnownAliases5() {
		return knownAliases5;
	}
	public void setKnownAliases5(String knownAliases5) {
		this.knownAliases5 = knownAliases5;
	}
	public String getKnownAliases6() {
		return knownAliases6;
	}
	public void setKnownAliases6(String knownAliases6) {
		this.knownAliases6 = knownAliases6;
	}
	public String getKnownAliases7() {
		return knownAliases7;
	}
	public void setKnownAliases7(String knownAliases7) {
		this.knownAliases7 = knownAliases7;
	}
	
	
}	
