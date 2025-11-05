package com.kh.spring.cart.model.service;

import java.util.List;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.vo.Cart;


public interface CartService {
    List<CartDTO> getCartList(int memberNo);
    int addCart(Cart cart);
    int updateCartQuantity(Cart cart);
    int removeCart(int cartNo);
    int updateCheckedStatus(int cartNo, String isChecked);
}