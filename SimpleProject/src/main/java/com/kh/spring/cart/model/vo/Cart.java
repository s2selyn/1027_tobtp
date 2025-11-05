package com.kh.spring.cart.model.vo;

import java.util.Date;
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
public class Cart {
    private int cartNo;
    private Integer memberNo;
    private int productNo;
    private int quantity;
    private String optionText;
    private String isChecked;
    private Date addedDate;
    private Date updatedDate;
}


