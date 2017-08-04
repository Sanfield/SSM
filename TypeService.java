package com.mybatis.service;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.commom.DBUtil;
import com.mybatis.dao.TypeMapper;
import com.mybatis.vo.TypeInfo;

public class TypeService  {

	public List<TypeInfo> getTypes() {
		List<TypeInfo> list= null;
		SqlSession session = DBUtil.getSqlSession();
		try{
			TypeMapper mapper= session.getMapper(TypeMapper.class);
			list=mapper.getTypes();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		return list;
	}



}
