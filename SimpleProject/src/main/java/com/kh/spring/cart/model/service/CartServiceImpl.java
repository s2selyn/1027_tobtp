package com.kh.spring.cart.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.mapper.CartDao;
import com.kh.spring.cart.model.vo.Cart;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	
	private final CartDao cartMapper;

	@Override
	public void addCart(Cart cart) {
		
		// 같은 상품 인지? 같은 상품이면 수량 UPdate하긴해야함
		// 
		cartMapper.insertCart(cart);
	}

	@Override
	public List<CartDTO> getCartList() {
		return cartMapper.selectAll();
	}

	@Override
	public void removeCart(int cartNo) {
		cartMapper.deleteCart(cartNo);
	}

}


