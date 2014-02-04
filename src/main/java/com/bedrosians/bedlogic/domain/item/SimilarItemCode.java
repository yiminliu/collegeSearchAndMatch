package com.bedrosians.bedlogic.domain.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SimilarItemCode extends UnitInfo implements java.io.Serializable {
			
	@Column(name = "similar_itemcd1", length = 18)
	private String similarItemCode1;	
	@Column(name = "similar_itemcd2", length = 18)
	private String similarItemCode2;	
	@Column(name = "similar_itemcd3", length = 18)
	private String similarItemCode3;	
	@Column(name = "similar_itemcd4", length = 18)
	private String similarItemCode4;		
	@Column(name = "similar_itemcd5", length = 18)
	private String similarItemCode5;	
	@Column(name = "similar_itemcd6", length = 18)
	private String similarItemCode6;	
	@Column(name = "similar_itemcd7", length = 18)
	private String similarItemCode7;
	
	
	public String getSimilarItemCode1() {
		return similarItemCode1;
	}

	public void setSimilarItemCode1(String similarItemCode1) {
		this.similarItemCode1 = similarItemCode1;
	}

	public String getSimilarItemCode2() {
		return similarItemCode2;
	}

	public void setSimilarItemCode2(String similarItemCode2) {
		this.similarItemCode2 = similarItemCode2;
	}

	public String getSimilarItemCode3() {
		return similarItemCode3;
	}

	public void setSimilarItemCode3(String similarItemCode3) {
		this.similarItemCode3 = similarItemCode3;
	}

	public String getSimilarItemCode4() {
		return similarItemCode4;
	}

	public void setSimilarItemCode4(String similarItemCode4) {
		this.similarItemCode4 = similarItemCode4;
	}

	public String getSimilarItemCode5() {
		return similarItemCode5;
	}

	public void setSimilarItemCode5(String similarItemCode5) {
		this.similarItemCode5 = similarItemCode5;
	}

	public String getSimilarItemCode6() {
		return similarItemCode6;
	}

	public void setSimilarItemCode6(String similarItemCode6) {
		this.similarItemCode6 = similarItemCode6;
	}

	public String getSimilarItemCode7() {
		return similarItemCode7;
	}

	public void setSimilarItemCode7(String similarItemCode7) {
		this.similarItemCode7 = similarItemCode7;
	}
		
}	
