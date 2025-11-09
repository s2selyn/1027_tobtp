package com.kh.spring.product.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.product.model.dto.ProductDetailDTO;
import com.kh.spring.product.model.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String home(@RequestParam(value="page", defaultValue="1") Long page, Model model) {
        Map<String, Object> result = productService.findAll(page);
        model.addAttribute("productList", result.get("products"));
        model.addAttribute("pi", result.get("pi"));
        return "index"; // -> /WEB-INF/views/index.jsp
    }

    
    @GetMapping("/productDetail")
		public String toDetail(@RequestParam("productNo") int productNo, Model model) {
	    ProductDetailDTO dto = productService.getProductDetail(productNo);
	
	    String formattedPrice = String.format("%,d", dto.getProduct().getPrice());
	
	    model.addAttribute("dto", dto);
	    model.addAttribute("formattedPrice", formattedPrice);
	    return "product/productDetail";
    }
    
    /*
    @GetMapping("/productDetail")
    public String toDetail(@RequestParam("productNo") int productNo, Model model) {
        ProductDetailDTO dto = productService.getProductDetail(productNo);

        // 가격 포맷
        String formattedPrice = String.format("%,d", dto.getProduct().getPrice());

        model.addAttribute("product", dto.getProduct());  // JSP에서는 product로 접근
        model.addAttribute("colorList", dto.getColorList());
        model.addAttribute("sizeList", dto.getSizeList());
        model.addAttribute("formattedPrice", formattedPrice);
        
        log.info("ColorList: {}", dto.getColorList());
        log.info("SizeList: {}", dto.getSizeList());
        log.info("Product: {}", dto.getProduct());
        log.info("ColorList: {}", dto.getColorList());
        log.info("SizeList: {}", dto.getSizeList());

        return "product/productDetail";
    }
    */
}
 