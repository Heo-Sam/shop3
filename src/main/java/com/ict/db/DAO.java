package com.ict.db;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	// 리스트
	public static List<VO> getList(String category){
		List<VO> list = null;
		list = getSession().selectList("list", category);
		return list;
	}
	
	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	// 로그인 
	public static MVO getLogIn(MVO m_vo) {
		MVO mvo = null;
		mvo = getSession().selectOne("login", m_vo);
		return mvo;
	}
	
	// 상품등록
	public static int getProductInsert(VO vo) {
		int result = 0 ;
		try {
			result = getSession().insert("product_add", vo);
		} catch (Exception e) {
			System.out.println(e);
		}
		ss.commit();
		
		return result;
	}
	
	// 장바구니 검색? 
	public static CVO getCartSearch(String userid, String p_num) {
		CVO cvo = null;
		CVO c_vo = new CVO();
		c_vo.setUserid(userid);
		c_vo.setP_num(p_num);
		cvo = getSession().selectOne("cart_search", c_vo);
		
		return cvo;
	}
	
	// 장바구니 담기(insert)
	public static int getCartInsert(CVO c_vo) {
		int result = 0;
		result = getSession().insert("cart_insert", c_vo);
		ss.commit();
		
		return result;
	}
	
	// 장바구니 수량 증가(update)
	public static int getCartUpdate(CVO cvo) {
		int result = 0;
		result = getSession().update("cart_update", cvo);
		ss.commit();
		
		return result;
	}
	
	// 장바구니 리스트
	public static List<VO> getCartList(String userid) {
		List<VO> cList = null;
		cList = getSession().selectList("cart_list", userid);
		
		return cList;		
	}
	
	// 장바구니 삭제 
	public static int getCartDelete(CVO cvo) {
		int result = 0;
		result = getSession().delete("cart_delete", cvo);
		
		return result;
	}
	
	// 장바구니 수량 업데이트
	public static int getCartQuantUpdate(CVO cvo) {
		int result = 0;
		result = getSession().update("cart_Quant_update", cvo);
		ss.commit();
		
		return result;
	}
	
}

















