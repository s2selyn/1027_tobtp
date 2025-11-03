package com.kh.spring.product.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.spring.product.model.dto.ProductSaveDTO;

@Mapper
public interface ProductSaveMapper {
	
	int save(ProductSaveDTO product);

}
