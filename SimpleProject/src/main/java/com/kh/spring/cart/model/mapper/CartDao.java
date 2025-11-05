package com.kh.spring.cart.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.cart.model.dto.CartDTO;
import com.kh.spring.cart.model.vo.Cart;


@Mapper
public interface CartDao {

    @Select("""
        SELECT 
               C.CART_NO
             , C.MEMBER_NO
             , C.PRODUCT_NO
             , C.QUANTITY
             , C.OPTION_TEXT
             , C.IS_CHECKED
             , P.PRODUCT_NAME
             , P.PRICE
             , P.CHANGE_NAME
          FROM 
    		   TB_CART C
          JOIN 
               TB_PRODUCT P ON C.PRODUCT_NO = P.PRODUCT_NO
         WHERE 
               C.MEMBER_NO = #{memberNo}
    """)
    List<CartDTO> selectCartByMember(int memberNo);

    @Insert("""
        INSERT
          INTO 
               TB_CART
               (
               CART_NO
             , MEMBER_NO
             , PRODUCT_NO
             , QUANTITY
             , OPTION_TEXT
             , IS_CHECKED
             , ADDED_DATE
    		   ) 
       VALUES (
              SEQ_CART_NO.NEXTVAL
            , #{memberNo}
            , #{productNo}
            , #{quantity}
            , #{optionText}
            , #{isChecked}
            , SYSDATE
    		  )
    """)
    int insertCart(Cart cart);

    @Update("""
        UPDATE TB_CART 
        SET QUANTITY = #{quantity}, UPDATED_DATE = SYSDATE 
        WHERE CART_NO = #{cartNo}
    """)
    int updateCartQuantity(Cart cart);

    @Delete("DELETE FROM TB_CART WHERE CART_NO = #{cartNo}")
    int deleteCart(int cartNo);

    @Update("UPDATE TB_CART SET IS_CHECKED = #{isChecked} WHERE CART_NO = #{cartNo}")
    int updateCheckedStatus(int cartNo, String isChecked);
}
