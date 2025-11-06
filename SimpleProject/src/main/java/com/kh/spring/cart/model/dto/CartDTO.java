package com.kh.spring.cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartDTO {
    private int cartNo;
    private int productNo;
    private int quantity;
    private String optionText;
    private String isChecked;
    private String productName;
    private int price;
}
