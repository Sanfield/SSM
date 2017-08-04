package com.mybatis.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.commom.DBUtil;
import com.mybatis.dao.UserMapper;
import com.mybatis.vo.UserInfo;

public class UserService {
	
	public UserInfo getInfoById(String name) {
		UserInfo user=null;
		SqlSession session= DBUtil.getSqlSession();
		try{
			UserMapper mapper= session.getMapper(UserMapper.class);
			user=mapper.getInfoById(name);
			System.out.println("ÐÕÃû£º"+user);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return user;
	}

}
