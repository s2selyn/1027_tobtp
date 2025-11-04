package com.kh.spring.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.spring.product.model.dto.CategoryDTO;
import com.kh.spring.product.model.dto.ProductDetailDTO;
import com.kh.spring.product.model.vo.Category;



public interface ProductService {
	// 전체 상품 조회 + 페이징
    Map<String, Object> findAll(Long page);

    // 상품 상세
    ProductDetailDTO getProductDetail(int productNo);
       
    // 사이드바
    List<Category> getAllCategories();
    
    // 카테고리 클릭시 실행하는거
    List<CategoryDTO> getProductsByCategory(int categoryNum);
}
