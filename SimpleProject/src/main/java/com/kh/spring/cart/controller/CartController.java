package com.kh.spring.cart.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.service.CartService;
import com.kh.spring.cart.model.vo.Cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @GetMapping("")
    public ModelAndView cartPage(ModelAndView mv) {
        List<CartDTO> cartList = cartService.getCartList();
        mv.addObject("cartList", cartList);
        log.info("cartList{}",cartList);
        mv.setViewName("cart/cart_list");
        return mv;
    }

    @PostMapping("/add")
    public String addCart(@ModelAttribute Cart cart) {
        cartService.addCart(cart);
        log.info("장바구니 추가됨: {}", cart);
        return "redirect:/cart";
    }

    @PostMapping("/delete")
    public String deleteCart(@ModelAttribute CartDTO cart) {
        cartService.removeCart(cart.getCartNo());
        log.info("나 호출됨?");
        return "redirect:/cart";
    }
}
