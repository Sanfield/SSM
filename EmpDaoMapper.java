package com.imn.dao;

import java.io.Serializable;

import com.imn.entity.ProductInfo;

public class EmpDaoMapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer empid;
	private String empName;
	private ProductInfo product;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	
}
