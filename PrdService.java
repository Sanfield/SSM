package com.mybatis.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.commom.DBUtil;
import com.mybatis.dao.PrdMapper;
import com.mybatis.vo.ProductInfo;


public class PrdService {

	public List<ProductInfo> getAllPrd() {
		
		List<ProductInfo> list=null;
		SqlSession session= DBUtil.getSqlSession();
		try{
			PrdMapper mapper= session.getMapper(PrdMapper.class);
			list=mapper.getAllPrd();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		//System.out.println(list);
		return list;
	}

	public Integer addPrd(ProductInfo prd) {
		Integer count=null;
		SqlSession session= DBUtil.getSqlSession();
		try{
			PrdMapper mapper= session.getMapper(PrdMapper.class);
			count=mapper.addPrd(prd);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return count;
	}

	public List<ProductInfo> search(Map<String, Object> sprd) {
		
		List<ProductInfo> list=null;
		SqlSession session= DBUtil.getSqlSession();
		try{
			PrdMapper mapper= session.getMapper(PrdMapper.class);
			list=mapper.search(sprd);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return list;
	}

	public Integer batchDelete(int[] prdArray) {
		Integer count=null;
		SqlSession session= DBUtil.getSqlSession();
		try{
			PrdMapper mapper= session.getMapper(PrdMapper.class);
			count=mapper.batchDelete(prdArray);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return count;
	}
	
	

}
