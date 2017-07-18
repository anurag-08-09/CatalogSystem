package com.globomart.cams.utils;

import com.globomart.cams.entity.CategoryMetadata;
import com.globomart.cams.entity.ProductInformationDTO;
import com.globomart.cams.requests.AddProductRequest;

public abstract class ConverterUtils {

	public static ProductInformationDTO getProductInformationDTO(AddProductRequest request){
		if(request == null || request.getCategoryId() == null || request.getProductName() == null){
			return null;
		}
		ProductInformationDTO productInformationDTO = new ProductInformationDTO();
		productInformationDTO.setProductName(request.getProductName());
		productInformationDTO.setProductImage(request.getProductImage());
		CategoryMetadata categoryMetadata  = new CategoryMetadata();
		categoryMetadata.setCategoryId(request.getCategoryId());
		productInformationDTO.setCategoryMetadata(categoryMetadata);
		return productInformationDTO;
	}
}
