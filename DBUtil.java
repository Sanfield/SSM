package com.mybatis.commom;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	
  private static SqlSessionFactory factory;
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("com/mybatis/dao/Configuration.xml");
			// ���ù�������������
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * ��ȡSqlSession����
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
}
