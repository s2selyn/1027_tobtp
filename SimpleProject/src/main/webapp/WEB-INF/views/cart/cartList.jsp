<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
  margin: 0;
}

* {
  box-sizing: border-box;
}

p,
span {
  margin: 0;
}

a {
  color: black;
}

img {
  display: block;
  width: 80%;
  height: 80px;
  margin: auto;
}

.cart {
  width: 80%;
  margin: auto;
  padding: 30px;
}

.cart ul {
  background-color: whitesmoke;
  padding: 30px;
  margin-bottom: 50px;
  border: whitesmoke solid 1px;
  border-radius: 5px;
  font-size: 13px;
  font-weight: 300;
}

.cart ul :first-child {
  color: limegreen;
}

table {
  border-top: solid 1.5px black;
  border-collapse: collapse;
  width: 100%;
  font-size: 14px;
}

thead {
  text-align: center;
  font-weight: bold;
}

tbody {
  font-size: 12px;
}

td {
  padding: 15px 0px;
  border-bottom: 1px solid lightgrey;
}

.cart__list__detail :nth-child(3) {
  vertical-align: top;
}

.cart__list__detail :nth-child(3) a {
  font-size: 12px;
}

.cart__list__detail :nth-child(3) p {
  margin-top: 6px;
  font-weight: bold;
}

.cart__list__smartstore {
  font-size: 12px;
  color: gray;
}

.cart__list__option {
  vertical-align: top;
  padding: 20px;
}

.cart__list__option p {
  margin-bottom: 25px;
  position: relative;
}

.cart__list__option p::after {
  content: "";
  width: 90%;
  height: 1px;
  background-color: lightgrey;
  left: 0px;
  top: 25px;
  position: absolute;
}

.cart__list__optionbtn {
  background-color: white;
  font-size: 10px;
  border: lightgrey solid 1px;
  padding: 7px;
}

.cart__list__detail :nth-child(4),
.cart__list__detail :nth-child(5),
.cart__list__detail :nth-child(6) {
  border-left: 2px solid whitesmoke;
}

.cart__list__detail :nth-child(5),
.cart__list__detail :nth-child(6) {
  text-align: center;
}

.cart__list__detail :nth-child(5) button {
  background-color: limegreen;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 4px 8px;
  font-size: 12px;
  margin-top: 5px;
}

.price {
  font-weight: bold;
}

.cart__mainbtns {
  width: 420px;
  height: 200px;
  padding-top: 40px;
  display: block;
  margin: auto;
}

.cart__bigorderbtn {
  width: 200px;
  height: 50px;
  font-size: 16px;
  margin: auto;
  border-radius: 5px;
}

.cart__bigorderbtn.left {
  background-color: white;
  border: 1px lightgray solid;
}

.cart__bigorderbtn.right {
  background-color: limegreen;
  color: white;
  border: none;
}
</style>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
    <section class="cart">
        <div class="cart__information">
            <ul>
                <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
                <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
            </ul>
        </div>
        <c:choose>
		    <c:when test="${not empty sessionScope.memberNo}">
		        <p style="padding: 10px; background-color: #e8f5e9; color: #2e7d32; border-radius: 5px;">
		            로그인 상태입니다. 장바구니는 계정에 저장됩니다.
		        </p>
		    </c:when>
		    <c:otherwise>
		        <p style="padding: 10px; background-color: #fff3e0; color: #ef6c00; border-radius: 5px;">
		            비로그인 상태입니다. 장바구니는 임시로 저장되며, 브라우저를 닫으면 사라집니다.
		        </p>
		    </c:otherwise>
		</c:choose>
        <table class="cart__list">
            <thead>
                <tr>
                    <td><input type="checkbox"></td>
                    <td colspan="2">상품정보</td>
                    <td>옵션</td>
                    <td>상품금액</td>
                    <td>배송비</td>
                </tr>
            </thead>
            <tbody>
                <!-- 장바구니 항목들을 반복하여 출력 -->
                <c:forEach var="item" items="${cartList}">
                    <tr class="cart__list__detail">
                        <td><input type="checkbox" <c:if test="${item.isChecked == 'Y'}">checked</c:if>></td>
                        <td><img src="image/${item.productNo}.jpg" alt="${item.productNo}"></td>
                        <td>
                            <a href="#">${item.productName}</a>
                            <p>${item.productName} - 수량: ${item.quantity}</p>
                        </td>
                        <td>
                            <button class="cart__list__optionbtn">옵션 변경</button>
                        </td>
                        <td><span class="price">${item.price * item.quantity}원</span></td>
                        <td>무료</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="6">
                        <button class="cart__list__optionbtn">선택상품 삭제</button>
                        <button class="cart__list__optionbtn">선택상품 찜</button>
                    </td>
                </tr>
            </tfoot>
        </table>
        <div class="cart__mainbtns">
            <button class="cart__bigorderbtn left">쇼핑 계속하기</button>
            <button class="cart__bigorderbtn right">주문하기</button>
        </div>
    </section>
    <jsp:include page="../include/footer.jsp" />
</body>
</html>