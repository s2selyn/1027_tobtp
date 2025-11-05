package com.kh.spring.product.model.service;

import java.util.Map;

import com.kh.spring.product.model.dto.ProductDetailDTO;



public interface ProductService {
	// 전체 상품 조회 + 페이징
    Map<String, Object> findAll(Long page);

    // 상품 상세
    ProductDetailDTO getProductDetail(int productNo);
}
