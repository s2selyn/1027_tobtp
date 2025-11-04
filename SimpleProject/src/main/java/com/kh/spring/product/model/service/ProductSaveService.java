package com.kh.spring.product.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.product.model.dto.ProductSaveDTO;

public interface ProductSaveService {
	
	int save(ProductSaveDTO product, MultipartFile upfile, HttpSession session);

}