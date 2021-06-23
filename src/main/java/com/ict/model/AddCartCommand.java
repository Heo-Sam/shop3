package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class AddCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		// 해당 제품을 구입한 id를 구한다 
		// LogIn_OKCommand.java파일 -> session에 mvo가 담겨있다.
		MVO mvo = (MVO) request.getSession().getAttribute("mvo");
		String userid = mvo.getId();
		
		// idx를 이용해서 제품정보를 db에서 가져온다
		VO vo = DAO.getOneList(idx);
		
		// 해당 아이디를 가진 사람이 db에서 제품을 가지고 있는 지 검사한다
		CVO cvo =  DAO.getCartSearch(userid, vo.getP_num());
		
		// 카트에 해당 제품이 있을수도 있고 없을수도 있음
		if (cvo == null) {
			// 카트에 제품 없으면 카트 테이블에 추가
			CVO c_vo = new CVO();
			c_vo.setP_num(vo.getP_num());
			c_vo.setP_name(vo.getP_name());
			c_vo.setP_price(String.valueOf(vo.getP_price()));
			c_vo.setP_saleprice(String.valueOf(vo.getP_saleprice()));
			c_vo.setQuant("1"); // 선택사항 (SQL에서 넣을 수 있다)
			c_vo.setUserid(userid);
			
			int result = DAO.getCartInsert(c_vo);
		} else {
			// 카트에 제품이 있으면 제품의 수량을 1증가
			int result = DAO.getCartUpdate(cvo);
		}
		
		
		return "MyController?cmd=onelist";
	}
}
