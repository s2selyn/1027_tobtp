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
    public List<CartDTO> getCartList(int memberNo) {
        return cartMapper.selectCartByMember(memberNo);
    }

    @Override
    public int addCart(Cart cart) {
        return cartMapper.insertCart(cart);
    }

    @Override
    public int updateCartQuantity(Cart cart) {
        return cartMapper.updateCartQuantity(cart);
    }

    @Override
    public int removeCart(int cartNo) {
        return cartMapper.deleteCart(cartNo);
    }

    @Override
    public int updateCheckedStatus(int cartNo, String isChecked) {
        return cartMapper.updateCheckedStatus(cartNo, isChecked);
    }
}
