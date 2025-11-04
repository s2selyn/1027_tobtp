<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>상품 상세보기</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f5f7fa;
      font-family: 'Noto Sans KR', sans-serif;
    }

    .product-container {
      max-width: 1000px;
      margin: 60px auto;
      background-color: #fff;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0,0,0,0.08);
      overflow: hidden;
    }

    .product-img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      border-right: 1px solid #eee;
    }

    .product-info {
      padding: 40px;
    }

    .product-name {
      font-size: 1.8rem;
      font-weight: 700;
      color: #222;
    }

    .seller {
      font-size: 1rem;
      color: #777;
      margin-bottom: 15px;
    }

    .product-desc {
      font-size: 1rem;
      color: #555;
      line-height: 1.6;
      margin-bottom: 25px;
    }

    .dropdown-select {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 8px;
      background-color: #fff;
      transition: all 0.2s ease;
    }

    .dropdown-select:focus {
      border-color: #007bff;
      box-shadow: 0 0 0 0.2rem rgba(0,123,255,0.25);
      outline: none;
    }

    .btn-buy {
      border-radius: 8px;
      padding: 12px;
      font-size: 1rem;
      font-weight: 600;
    }

    .btn-buy {
      background-color: #007bff;
      color: #fff;
    }

    .btn-buy:hover {
      background-color: #0069d9;
    }
  </style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	
	
  <c:set var="product" value="${dto.product}" />
<c:set var="colorList" value="${dto.colorList}" />
<c:set var="sizeList" value="${dto.sizeList}" />

<div class="product-container row g-0">
    <!-- 상품 이미지 -->
    <div class="col-md-6">
        <c:choose>
            <c:when test="${not empty product.changeName}">
                <img src="${pageContext.request.contextPath}/resources/upload/${product.changeName}" 
                     alt="상품 이미지" class="product-img">
            </c:when>
            <c:otherwise>
                <img src="https://via.placeholder.com/600x600" alt="상품 이미지" class="product-img">
            </c:otherwise>
        </c:choose>
    </div>

    <!-- 상품 정보 -->
    <div class="col-md-6 product-info">
        <h2 class="product-name">${product.productName}</h2>
        <p class="seller">판매자: <strong>${product.memberNo}</strong></p>
        <p class="text-primary fs-4 fw-bold mb-4">₩${formattedPrice}</p>
        <p class="text-muted">카테고리: ${product.categoryNo}</p>
        <hr>

        <p class="product-desc">
            <c:out value="${product.detailContent}" />
        </p>

        <!-- 색상 선택 -->
        <div class="mb-4">
            <label for="color" class="form-label fw-bold">색상 선택</label>
            <select id="color" class="dropdown-select">
                <option value="">색상을 선택하세요</option>
                <c:forEach var="color" items="${colorList}">
                    <option value="${color.colorNo}">${color.colorName}</option>
                </c:forEach>
            </select>
        </div>

        <!-- 사이즈 선택 -->
        <div class="mb-4">
            <label for="size" class="form-label fw-bold">사이즈 선택</label>
            <select id="size" class="dropdown-select">
                <option value="">사이즈를 선택하세요</option>
                <c:forEach var="size" items="${sizeList}">
                    <option value="${size.sizeNo}">${size.sizeName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="d-grid gap-2 mt-4">
            <button class="btn btn-buy" onclick="buyNow(${product.productNo})">구매하기</button>
        </div>
    </div>
</div>

<script>
	function buyNow(productNo) {
	    const color = document.getElementById('color').value;
	    const size = document.getElementById('size').value;
	    if (!color || !size) {
	        alert('색상과 사이즈를 선택해주세요.');
	        return;
	    }
	    alert(`상품 구매를 위해 장바구니로 이동합니다.`);
	    // 실제 구매 페이지로 이동 처리
	}
</script>
  
  
  <jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>
</html>
	