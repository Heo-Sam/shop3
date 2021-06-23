package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class DeleteCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CVO cvo = new CVO();
		cvo.setUserid(request.getParameter("id"));
		cvo.setP_num(request.getParameter("p_num"));
		
		int result = DAO.getCartDelete(cvo);
		
		
		return "MyController?cmd=showCart";
	}
}
