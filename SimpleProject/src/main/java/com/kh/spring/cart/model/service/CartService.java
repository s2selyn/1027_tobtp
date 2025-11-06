package com.kh.spring.cart.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.vo.Cart;

public interface CartService {


	void addCart(Cart cart);
	List<CartDTO> getCartList(); 
	void removeCart(int cartNo);

}
