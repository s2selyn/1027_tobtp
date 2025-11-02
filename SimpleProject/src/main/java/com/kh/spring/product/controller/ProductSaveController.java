package com.kh.spring.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.product.model.ProductDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("product")
public class ProductSaveController {
	
	@GetMapping("form")
	public String toForm() {
		
		return "/product/form";
		// 아직 페이지 없음
		
	}
	
	@PostMapping
	public String save(ProductDTO product, MultipartFile upfile, HttpSession session) {
		
		log.info("게시글 정보 : {}, 파일 정보 : {}", product, upfile);
		
		return "redirect:product/product";
		
	}

}
