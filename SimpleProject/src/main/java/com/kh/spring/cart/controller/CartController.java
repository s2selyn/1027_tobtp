package com.kh.spring.cart.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.service.CartService;
import com.kh.spring.cart.model.vo.Cart;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 목록 조회
    @GetMapping
    public ModelAndView cartList(HttpSession session) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");
        ModelAndView mav = new ModelAndView("cart/cartList");

        if (memberNo != null) {
            List<CartDTO> cartList = cartService.getCartList(memberNo);
            mav.addObject("cartList", cartList);
        } else {
            List<Cart> sessionCartList = getCartListFromSession(session);
            // 세션 Cart → CartDTO 변환 (간단히)
            List<CartDTO> dtoList = new ArrayList<>();
            for (Cart c : sessionCartList) {
                CartDTO dto = new CartDTO();
                dto.setCartNo(c.getCartNo());
                dto.setProductNo(c.getProductNo());
                dto.setQuantity(c.getQuantity());
                dto.setOptionText(c.getOptionText());
                dto.setIsChecked(c.getIsChecked());
                // TODO: 상품명/가격 조회 로직 추가 (ProductService 사용 or Mock 값)
                dto.setProductName("상품명");
                dto.setPrice(10000);
                dtoList.add(dto);
            }
            mav.addObject("cartList", dtoList);
        }
        return mav;
    }


    // 장바구니에 상품 추가
    @PostMapping("/add")
    public String addCart(HttpSession session, @ModelAttribute Cart cart) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        if (memberNo != null) {
            // 로그인한 상태: DB에 추가
            cart.setMemberNo(memberNo);
            cartService.addCart(cart);
        } else {
            // 비로그인 상태: 세션에 추가
            addCartToSession(session, cart);
        }

        return "redirect:/cart";
    }

    // 장바구니에서 상품 삭제
    @PostMapping("/delete")
    public String deleteCart(HttpSession session, @RequestParam("productNo") int productNo) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        if (memberNo != null) {
            // 로그인한 상태: DB에서 삭제
            cartService.removeCart(productNo);
        } else {
            // 비로그인 상태: 세션에서 삭제
            removeCartFromSession(session, productNo);
        }

        return "redirect:/cart";
    }

    // 체크박스 상태 변경
    @PostMapping("/check")
    public String updateCheck(HttpSession session, @RequestParam("cartNo") int cartNo,
                              @RequestParam("isChecked") String isChecked) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        if (memberNo != null) {
            // 로그인한 상태: DB에서 체크 상태 업데이트
            cartService.updateCheckedStatus(cartNo, isChecked);
        } else {
            // 비로그인 상태: 세션에서 체크 상태 업데이트
            updateCheckStatusInSession(session, cartNo, isChecked);
        }

        return "redirect:/cart";
    }

    // 비로그인 상태에서 세션에서 장바구니 가져오기
    private List<Cart> getCartListFromSession(HttpSession session) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cartList", cartList);
        }
        return cartList;
    }

    // 비로그인 상태에서 세션에 장바구니 상품 추가
    private void addCartToSession(HttpSession session, Cart cart) {
        List<Cart> cartList = getCartListFromSession(session);

        // 이미 장바구니에 해당 상품이 있는지 확인
        boolean found = false;
        for (Cart item : cartList) {
            if (item.getProductNo() == cart.getProductNo()) {
                item.setQuantity(item.getQuantity() + cart.getQuantity());
                found = true;
                break;
            }
        }

        if (!found) {
            cartList.add(cart);
        }

        session.setAttribute("cartList", cartList);
    }

    // 비로그인 상태에서 세션에서 장바구니 상품 삭제
    private void removeCartFromSession(HttpSession session, int productNo) {
        List<Cart> cartList = getCartListFromSession(session);

        if (cartList != null) {
            cartList.removeIf(item -> item.getProductNo() == productNo);
        }

        session.setAttribute("cartList", cartList);
    }

    // 비로그인 상태에서 세션에서 체크 상태 업데이트
    private void updateCheckStatusInSession(HttpSession session, int cartNo, String isChecked) {
        List<Cart> cartList = getCartListFromSession(session);

        if (cartList != null) {
            for (Cart cart : cartList) {
                if (cart.getCartNo() == cartNo) {
                    cart.setIsChecked(isChecked);
                    break;
                }
            }
        }

        session.setAttribute("cartList", cartList);
    }
}


