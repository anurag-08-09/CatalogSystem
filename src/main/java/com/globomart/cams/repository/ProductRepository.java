package com.globomart.cams.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globomart.cams.entity.ProductInformationDTO;

@Transactional
@Repository("product_repository")
public interface ProductRepository extends JpaRepository<ProductInformationDTO, Integer> {

	@Query("SELECT p FROM ProductInformationDTO p WHERE p.categoryMetadata.categoryId=?1")
	public List<ProductInformationDTO> find(@Param("categoryId") Integer categoryId);
	
}
