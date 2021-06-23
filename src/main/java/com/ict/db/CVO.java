package com.ict.db;

public class CVO {
	private String c_idx, s_idx, userid, p_num, p_name, p_price,p_saleprice, quant, total_price;

	
	/* // 장바구니에서 수량이 변경되면 장바구니 총 금액도 변경되어야 한다. 
	 * public void setQuant(int quant) {
	 * 		this.quant = quant; 
	 * 		// 주의) 나중에 할인제품과 아닌 제품을 구별해서 계산 해야 된다.
	 * 		setTotalPrice(quant * p_saleprice); 
	 * }
	 */
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getC_idx() {
		return c_idx;
	}
	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}
	public String getS_idx() {
		return s_idx;
	}
	public void setS_idx(String s_idx) {
		this.s_idx = s_idx;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_price() {
		return p_price;
	}
	public void setP_price(String p_price) {
		this.p_price = p_price;
	}
	public String getP_saleprice() {
		return p_saleprice;
	}
	public void setP_saleprice(String p_saleprice) {
		this.p_saleprice = p_saleprice;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	
}
