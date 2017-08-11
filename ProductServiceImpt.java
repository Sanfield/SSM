package com.spring.service;

import javax.annotation.Resource;

import com.spring.dao.ProductDao;
import com.spring.vo.ProductInfo;

public class ProductServiceImpt implements ProductService {
	@Resource(name="prdDao")
	private ProductDao prdDao;

	@Override
	public ProductInfo getInfoById(int i) {
		
		return prdDao.getInfoById(i);
	}

}
