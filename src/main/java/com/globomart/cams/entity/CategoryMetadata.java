package com.globomart.cams.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category_metadata")
public class CategoryMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3795001836709829464L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
	private int categoryId;
	
    @Column(name = "category_url", nullable = false, unique = true)
	private String categoryUrl;
    
    @Column(name = "category_display_name", nullable = false)
	private String categoryDisplayName;
    
    @Column(name = "visible", nullable = false)
	private boolean visible = true;
        
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryUrl() {
		return categoryUrl;
	}
	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	public String getCategoryDisplayName() {
		return categoryDisplayName;
	}
	public void setCategoryDisplayName(String categoryDisplayName) {
		this.categoryDisplayName = categoryDisplayName;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
