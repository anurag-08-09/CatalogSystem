package com.globomart.cams.service;

import java.util.List;

import com.globomart.cams.entity.ProductInformationDTO;

/**
 * @author sahilarora
 *
 */
public interface IProductCatalogService {

	/**
	 * 
	 * List all products for a category url
	 * 
	 * @param categoryUrl
	 * @return
	 */
	List<ProductInformationDTO> getProductsForACategoryUrl(String categoryUrl);

	
	/**
	 * 
	 * Insert a product in the catalog
	 * 
	 * @param categoryUrl
	 * @return
	 */
	ProductInformationDTO insertAProduct(ProductInformationDTO productInformationDTO);

	
	
	/**
	 * Delete a product from the catalog
	 * 
	 * @param productId
	 * @return
	 */
	boolean deleteAProduct(Integer productId);

}
