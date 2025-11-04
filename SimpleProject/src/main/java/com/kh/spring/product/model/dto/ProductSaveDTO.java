package com.kh.spring.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductSaveDTO {
	
	private Long productNo;
	private String productName;
	private int price;
	private int categoryNo;
	private int memberNo;
	private String detailContent;
	private String fileOriginName;
	private String changeName;

}
