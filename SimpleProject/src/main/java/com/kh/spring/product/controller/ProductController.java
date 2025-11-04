package com.kh.spring.product.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.product.model.dto.CategoryDTO;
import com.kh.spring.product.model.dto.ProductDetailDTO;
import com.kh.spring.product.model.service.ProductService;
import com.kh.spring.product.model.vo.Category;
import com.kh.spring.product.model.vo.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 홈 페이지
    @GetMapping("/")
    public String home() {
        return "index"; // index.jsp
    }

    // 카테고리 목록 반환 (AJAX)
    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getCategories() {
        log.info("카테고리 목록 불러오는 중...");
        return productService.getAllCategories();
    }

    // 상품 목록 반환 (categoryNum 쿼리 파라미터, AJAX)
    @GetMapping("/products")
    @ResponseBody
    public List<CategoryDTO> getProducts(
            @RequestParam(value="categoryNum", defaultValue="0") int categoryNum,
            @RequestParam(value="page", defaultValue="1") Long page) {

        log.info("상품 조회, categoryNum={}, page={}", categoryNum, page);

        if (categoryNum == 0) { // 전체보기
            Map<String, Object> result = productService.findAll(page);
            List<Product> products = (List<Product>) result.get("products");
            return products.stream()
                    .map(p -> new CategoryDTO(p.getProductNo(), p.getProductName(), p.getPrice(), p.getChangeName()))
                    .collect(Collectors.toList());
        } else { // 카테고리별
            return productService.getProductsByCategory(categoryNum);
        }
    }
    
    @GetMapping("/productDetail")
	public String toDetail(@RequestParam("productNo") int productNo, Model model) {
	    ProductDetailDTO dto = productService.getProductDetail(productNo);
	    System.out.println("dto: " + dto);
	    System.out.println("product: " + dto.getProduct());
	
	    String formattedPrice = String.format("%,d", dto.getProduct().getPrice());
	
	    model.addAttribute("dto", dto);
	    model.addAttribute("formattedPrice", formattedPrice);
	    return "/views/product/productDetail";
}
}
