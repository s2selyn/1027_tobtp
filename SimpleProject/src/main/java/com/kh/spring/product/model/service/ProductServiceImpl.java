package com.kh.spring.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.kh.spring.product.model.dto.CategoryDTO;
import com.kh.spring.product.model.dto.ProductDetailDTO;
import com.kh.spring.product.model.mapper.ProductMapper;
import com.kh.spring.product.model.vo.Category;
import com.kh.spring.product.model.vo.Color;
import com.kh.spring.product.model.vo.Product;
import com.kh.spring.product.model.vo.Size;
import com.kh.spring.util.PageInfo;
import com.kh.spring.util.Pagination;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Pagination pagination;
    private final ProductMapper productMapper;

    @Override
    public Map<String, Object> findAll(Long page) {

        Map<String, Object> map = new HashMap<>();

        int count = productMapper.selectTotalCount(); // 총 상품 개수

        PageInfo pi = pagination.getPageInfo(count, page.intValue(), 5, 5);

        List<Product> products;
        if (count > 0) {
            RowBounds rb = new RowBounds((page.intValue() - 1) * 5, 5);
            products = productMapper.findAll(rb);
        } else {
            products = List.of(); // 비어있는 리스트
        }

        map.put("pi", pi);
        map.put("products", products);

        return map;
    }


	@Override
	public ProductDetailDTO getProductDetail(int productNo) {
		List<Color> colorList = productMapper.selectColorsByProductNo(productNo);
		List<Size> sizeList = productMapper.selectSizesByProductNo(productNo);
		ProductDetailDTO dto = new ProductDetailDTO();
        dto.setProduct(productMapper.findByProductNo(productNo));
        dto.setColorList(productMapper.selectColorsByProductNo(productNo));
        dto.setSizeList(productMapper.selectSizesByProductNo(productNo));
        return dto;
	}



	@Override
	public List<Category> getAllCategories() {
		return productMapper.selectAllCategories();  
	}


	@Override
	public List<CategoryDTO> getProductsByCategory(int categoryNum) {
		return productMapper.selectProductsByCategory(categoryNum); 
	}

}
