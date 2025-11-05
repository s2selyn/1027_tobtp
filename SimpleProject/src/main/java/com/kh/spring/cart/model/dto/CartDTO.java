package com.kh.spring.cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private int cartNo;
    private Integer memberNo;
    private int productNo;
    private int quantity;
    private String optionText;
    private String isChecked;

    private String productName;
    private int price;
    private String changeName; // 이미지 파일명 (있다면)
}