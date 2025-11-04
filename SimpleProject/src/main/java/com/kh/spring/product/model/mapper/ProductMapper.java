package com.kh.spring.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.product.model.dto.CategoryDTO;
import com.kh.spring.product.model.vo.Category;
import com.kh.spring.product.model.vo.Color;
import com.kh.spring.product.model.vo.Product;
import com.kh.spring.product.model.vo.Size;

@Mapper
public interface ProductMapper {
    List<Product> findAll(RowBounds rb);
    int selectTotalCount();
    
    Product findByProductNo(@Param("productNo") int productNo);

    List<Color> selectColorsByProductNo(@Param("productNo") int productNo);

    List<Size> selectSizesByProductNo(@Param("productNo") int productNo);
    
    List<Category> selectAllCategories();
	List<CategoryDTO> selectProductsByCategory(int categoryNum);
}
