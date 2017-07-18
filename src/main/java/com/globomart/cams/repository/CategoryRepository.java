package com.globomart.cams.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globomart.cams.entity.CategoryMetadata;

@Transactional
@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryMetadata, Integer> {

	@Query("SELECT c FROM CategoryMetadata c WHERE c.categoryUrl like %?1")
	public List<CategoryMetadata> find(@Param("categoryUrl") String categoryUrl);

}
