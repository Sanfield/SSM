package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.vo.ProductInfo;

public interface PrdMapper {
	/**
	 * ��ȡ��Ʒ�б�
	 * @return
	 */
	List<ProductInfo> getAllPrd();

	/**
	 * �����Ʒ
	 * @param prd
	 * @return
	 */
	Integer addPrd(ProductInfo prd);

	/**
	 * ������Ʒ
	 * @param sprd
	 * @return
	 */
	List<ProductInfo> search(Map<String, Object> sprd);

	/**
	 * ���ɾ��
	 * @param prdArray
	 * @return
	 */
	Integer batchDelete(int[] prdArray);

}
