package com.kh.spring.cart.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.vo.Cart;

@Mapper
public interface CartDao {

    @Insert("""
        INSERT
    	  INTO
    		  TB_CART
    		  (
    		    CART_NO
    		  , PRODUCT_NO
    		  , QUANTITY
    		  , OPTION_TEXT
    		  , IS_CHECKED)
        VALUES (
    		   SEQ_CART_NO.NEXTVAL
    		  , #{productNo}
    		  , #{quantity}
    		  , #{optionText}
    		  , #{isChecked})
    """)
    void insertCart(Cart cart);

    @Select("""
        SELECT 
    		   C.CART_NO cartNo
    		 , C.PRODUCT_NO productNo
    		 , C.QUANTITY quantity
    		 , C.OPTION_TEXT optionText
    		 , C.IS_CHECKED isChecked
    		 , P.PRODUCT_NAME productName
    		 , P.PRICE price
          FROM 
    		   TB_CART C
          JOIN 
    		   TB_PRODUCT P ON C.PRODUCT_NO = P.PRODUCT_NO
         ORDER 
            BY
               C.CART_NO DESC
    """)
    List<CartDTO> selectAll();

    @Delete("DELETE FROM TB_CART WHERE CART_NO = #{cartNo}")
    void deleteCart(int cartNo);

}
