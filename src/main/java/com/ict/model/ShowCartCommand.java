package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class ShowCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * List<VO> cartList = Cart.cartList;
		 * 
		 * request.setAttribute("cartList", cartList); 
		 * request.setAttribute("total",Cart.total);
		 */
		
		// userid 가져오기
		MVO mvo =  (MVO) request.getSession().getAttribute("mvo");
		String userid = mvo.getId();
		
		// 해당 id가 가진 cart안의 모든 제품 가져오기
		List<VO> cartList =  DAO.getCartList(userid);
		
		request.setAttribute("cartList", cartList);
		
		return "view/viewcart.jsp";
	}
}
