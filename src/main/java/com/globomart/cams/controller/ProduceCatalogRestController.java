package com.globomart.cams.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.globomart.cams.entity.ProductInformationDTO;
import com.globomart.cams.requests.AddProductRequest;
import com.globomart.cams.service.IProductCatalogService;
import com.globomart.cams.utils.ConverterUtils;


@RestController
public class ProduceCatalogRestController {

	@Autowired
	IProductCatalogService productCatalogService;

	/**
	 * Controller to add a product in the globomart catalog
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "add-product", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody AddProductRequest request) {
		ProductInformationDTO productInformationDTO = productCatalogService
				.insertAProduct(ConverterUtils.getProductInformationDTO(request));
		if (productInformationDTO == null || productInformationDTO.getProductId() <= 0) {
			return ResponseEntity.badRequest().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(productInformationDTO.getProductId()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Controller to delete a product from the globomart catalog
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> add(@PathVariable("id") Integer productId) {
		boolean productDeleted = productCatalogService.deleteAProduct(productId);

		if (!productDeleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Controller to fetch all products in a category, here mapped by a category url
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "products/category/{categoryUrl}", method = RequestMethod.GET)
	ResponseEntity<List<ProductInformationDTO>> add(@PathVariable("categoryUrl") String categoryUrl) {
		List<ProductInformationDTO> products = productCatalogService.getProductsForACategoryUrl(categoryUrl);

		if (products == null || products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<List<ProductInformationDTO>>(products, HttpStatus.OK);
	}
}
