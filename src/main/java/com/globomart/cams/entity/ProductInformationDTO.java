package com.globomart.cams.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_information")
public class ProductInformationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3715468244298251850L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
	private Integer productId;
    
    @Column(name = "product_name", nullable = false)
	private String productName;
    
    @Column(name = "product_image", nullable = true)
   	private String productImage;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private CategoryMetadata categoryMetadata;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

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

	public CategoryMetadata getCategoryMetadata() {
		return categoryMetadata;
	}

	public void setCategoryMetadata(CategoryMetadata categoryMetadata) {
		this.categoryMetadata = categoryMetadata;
	}
    
}
