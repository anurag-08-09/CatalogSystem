package com.globomart.cams.requests;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AddProductRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5207922206110359578L;

	@NotNull
	private String productName;
	
	@NotNull
	private String productImage;
	
	@NotNull
	private Integer categoryId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "AddProductRequest [productName=" + productName + ", productImage=" + productImage + ", categoryId="
				+ categoryId + "]";
	}


}
