package com.globomart.cams.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globomart.cams.dao.IProductCatalogDao;
import com.globomart.cams.entity.CategoryMetadata;
import com.globomart.cams.entity.ProductInformationDTO;
import com.globomart.cams.repository.CategoryRepository;
import com.globomart.cams.repository.ProductRepository;

@Transactional
@Repository("productCatalogDaoImpl")
public class ProductCatalogDaoImpl implements IProductCatalogDao {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<ProductInformationDTO> getProductsOfACategory(int categoryId) {
		return productRepository.find(categoryId);
	}

	@Override
	public boolean deleteProduct(int productId) {
		productRepository.delete(productId);
		return true;
	}
	
	@Override
	public ProductInformationDTO addProduct(ProductInformationDTO productInformationDTO){
		return productRepository.save(productInformationDTO);
	}
	
	@Override
	public int getCategoryIdForACategoryUrl(String categoryUrl){
		List<CategoryMetadata> categories = categoryRepository.find(categoryUrl);
		if(categories == null || categories.isEmpty() ){
			return 0;
		}
		return categories.get(0).getCategoryId();
	}
}
