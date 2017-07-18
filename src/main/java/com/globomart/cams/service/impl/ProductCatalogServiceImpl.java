package com.globomart.cams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.globomart.cams.dao.IProductCatalogDao;
import com.globomart.cams.entity.ProductInformationDTO;
import com.globomart.cams.exceptions.CustomException;
import com.globomart.cams.service.IProductCatalogService;

@Service("productCatalogService")
public class ProductCatalogServiceImpl implements IProductCatalogService {

	@Autowired
	IProductCatalogDao productCatalogDao;

	@Override
	public List<ProductInformationDTO> getProductsForACategoryUrl(String categoryUrl) {
		if (categoryUrl == null || categoryUrl.isEmpty()) {
			// TODO: ADD LOGGER HERE
			System.out.println((new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Category URL not valid"))
					.toString());
			return null;
		}
		int categoryId = productCatalogDao.getCategoryIdForACategoryUrl(categoryUrl);
		if (categoryId <= 0) {
			// TODO: ADD LOGGER HERE
			System.out.println((new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" Products not found for category" + categoryUrl)).toString());
			return null;
		}
		return productCatalogDao.getProductsOfACategory(categoryId);
	}

	@Override
	public ProductInformationDTO insertAProduct(ProductInformationDTO productInformationDTO) {
		// TODO Auto-generated method stub
		if (productInformationDTO == null || productInformationDTO.getProductName() == null
				|| productInformationDTO.getProductImage() == null
				|| productInformationDTO.getCategoryMetadata() == null) {
			// TODO: ADD LOGGER HERE
			System.out.println((new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" Product information dto request is invalid")).toString());
			return null;
		}
		return productCatalogDao.addProduct(productInformationDTO);
	}

	@Override
	public boolean deleteAProduct(Integer productId) {
		// TODO Auto-generated method stub
		if (productId == null || productId.intValue() <= 0) {
			// TODO: ADD LOGGER HERE
			System.out.println((new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"category id is invalid for delete request")).toString());
			return false;
		}
		return productCatalogDao.deleteProduct(productId);
	}

}
