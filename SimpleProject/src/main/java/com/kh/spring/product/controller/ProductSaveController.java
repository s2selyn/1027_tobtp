package com.kh.spring.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.product.model.dto.ProductSaveDTO;
import com.kh.spring.product.model.service.ProductSaveService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductSaveController {
	
	private final ProductSaveService productSaveService;
	
	@GetMapping("/form")
	public String toForm() {
		
		log.info("form으로 보내는 여기 메소드가 호출되나요?");
		return "product/form";
		
	}
	
	@PostMapping
	public String save(ProductSaveDTO product, MultipartFile upfile, HttpSession session) {
		
		log.info("게시글 정보 : {}, 파일 정보 : {}", product, upfile);
		
		productSaveService.save(product, upfile, session);
		
		// save 성공했다면 리다이렉션
		return "redirect:product/product";
		
	}

}
