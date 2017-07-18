package com.globomart.cams.dao;

import java.util.List;

import com.globomart.cams.entity.ProductInformationDTO;

public interface IProductCatalogDao {

	List<ProductInformationDTO> getProductsOfACategory(int categoryId);

	boolean deleteProduct(int productId);

	ProductInformationDTO addProduct(ProductInformationDTO productInformationDTO);

	int getCategoryIdForACategoryUrl(String categoryUrl);

}
