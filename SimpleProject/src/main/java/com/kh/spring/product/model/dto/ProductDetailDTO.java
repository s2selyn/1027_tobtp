package com.kh.spring.product.model.dto;

import java.util.List;

import com.kh.spring.product.model.vo.Color;
import com.kh.spring.product.model.vo.Product;
import com.kh.spring.product.model.vo.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {

	private Product product;
    private List<Color> colorList;
    private List<Size> sizeList;
}
