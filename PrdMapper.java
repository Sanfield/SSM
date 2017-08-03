package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.vo.ProductInfo;

public interface PrdMapper {
	/**
	 * 获取商品列表
	 * @return
	 */
	List<ProductInfo> getAllPrd();

	/**
	 * 添加商品
	 * @param prd
	 * @return
	 */
	Integer addPrd(ProductInfo prd);

	/**
	 * 搜索商品
	 * @param sprd
	 * @return
	 */
	List<ProductInfo> search(Map<String, Object> sprd);

	/**
	 * 多个删除
	 * @param prdArray
	 * @return
	 */
	Integer batchDelete(int[] prdArray);

}
