<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지입니다.</title>
<style>
    body {
      font-family: 'Noto Sans KR', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #F8F9FA;
    }
    .container {
      display: flex;
      padding: 20px 40px;
    }
    /* 사이드바 */
    .sidebar {
      width: 250px;
      background: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      margin-right: 20px;
      height: fit-content;
    }
    .sidebar h3 {
      font-size: 18px;
      margin-bottom: 15px;
      color: #333;
      border-bottom: 2px solid #007BFF;
      padding-bottom: 5px;
    }
    .sidebar ul {
      list-style: none;
      padding: 0;
    }
    .sidebar ul li {
      margin-bottom: 10px;
      font-size: 15px;
      cursor: pointer;
      color: #333;
      transition: 0.3s;
    }
    .sidebar ul li:hover {
      color: #007BFF;
    }
    /* 메인 상품 영역 */
    .product-list {
      flex: 1;
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(230px, 1fr));
      gap: 20px;
    }
    .product-card {
      background: #fff;
      border-radius: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      padding: 15px;
      text-align: center;
      transition: 0.3s;
    }
    .product-card:hover {
      transform: translateY(-5px);
      box-shadow: 0 4px 12px rgba(0,0,0,0.15);
    }
    .product-card img {
      width: 100%;
      height: 180px;
      object-fit: cover;
      border-radius: 8px;
    }
    .product-card h4 {
      font-size: 16px;
      margin: 10px 0 5px;
      color: #333;
    }
    .product-card p {
      color: #007BFF;
      font-weight: bold;
    }
    .product-card a {
	  display: block;
	  text-decoration: none;
	  color: inherit;
	}
  </style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	
	<div class="container">

  <!-- 사이드바 -->
  <div class="sidebar">
    <h3>카테고리</h3>
    <ul>
      <c:forEach var="category" items="${categoryList}">
        <li>${category.categoryName}</li>
      </c:forEach>
    </ul>
  </div>

  <!-- 상품 목록 -->
  <div class="product-list">
	    <c:forEach var="product" items="${productList}">
		 <a href="${pageContext.request.contextPath}/productDetail?productNo=${product.productNo}">
		      <div class="product-card">
		        <img src="images/<c:out value='${product.changeName}'/>" alt="상품 이미지">
		        <h4><c:out value='${product.productName}'/></h4>
		        <p>₩<c:out value='${product.price}'/></p>
		      </div>
		  </a>
	    </c:forEach>
  </div>

</div>
	
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>
</html>