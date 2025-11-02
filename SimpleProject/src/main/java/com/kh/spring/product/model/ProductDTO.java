package com.kh.spring.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO {
	
	private Long productNo;
	private String productName;
	private int price;
	private int categoryNo;
	private String detailContent;
	private String fileOriginName;
	private String changeName;

}
