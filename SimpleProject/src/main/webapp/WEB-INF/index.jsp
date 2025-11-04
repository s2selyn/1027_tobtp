<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body { font-family: 'Noto Sans KR', sans-serif; background-color: #F8F9FA; margin:0; padding:0; }
    .container { display: flex; padding: 20px 40px; }
    .sidebar { width: 200px; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-right: 20px; }
    .sidebar h3 { font-size: 18px; margin-bottom: 15px; color: #333; border-bottom: 2px solid #007BFF; padding-bottom: 5px; }
    .sidebar ul { list-style: none; padding: 0; }
    .sidebar ul li { margin-bottom: 10px; font-size: 15px; cursor: pointer; color: #333; transition: 0.3s; }
    .sidebar ul li:hover, .sidebar ul li.active { color: #007BFF; font-weight: bold; }
    .product-list { flex: 1; display: grid; grid-template-columns: repeat(auto-fill, minmax(230px, 1fr)); gap: 20px; }
    .product-list a { text-decoration: none; color: inherit; display: block; }
    .product-card { background: #fff; border-radius: 10px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); padding: 15px; text-align: center; transition: 0.3s; }
    .product-card:hover { transform: translateY(-5px); box-shadow: 0 4px 12px rgba(0,0,0,0.15); }
    .product-card img { width: 100%; height: 180px; object-fit: cover; border-radius: 8px; }
    .product-card h4 { font-size: 16px; margin: 10px 0 5px; color: #333; }
    .product-card p { color: #007BFF; font-weight: bold; }
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<div class="container">
    <div class="sidebar">
        <h3>카테고리</h3>
        <ul id="categoryList">
            <li>로딩 중...</li>
        </ul>
    </div>
    <div class="product-list" id="productList">
        <p>상품을 불러오는 중...</p>
    </div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function loadCategories() {
    $.ajax({
        url: "${pageContext.request.contextPath}/categories",
        type: "GET",
        success: function(categories) {
            let html = '<li class="category-item active" data-id="0" onclick="loadProducts(0, this)">전체보기</li>';
            for(let i = 0; i < categories.length; i++) {
                let c = categories[i];
                html += '<li class="category-item" data-id="' + c.categoryNum + '" onclick="loadProducts(' + c.categoryNum + ', this)">' + c.categoryName + '</li>';
            }
            $("#categoryList").html(html);
            loadProducts(0, document.querySelector(".category-item"));
        },
        error: function() {
            $("#categoryList").html('<li>카테고리를 불러올 수 없습니다.</li>');
        }
    });
}

function loadProducts(categoryNum, elem) {
    $(".category-item").removeClass("active");
    $(elem).addClass("active");
    
    $.ajax({
        url: "${pageContext.request.contextPath}/products",
        type: "GET",
        data: { categoryNum: categoryNum },
        success: function(products) {
            if (!products || products.length === 0) {
                $("#productList").html('<p>상품이 없습니다.</p>');
                return;
            }
            
            let html = "";
            for(let i = 0; i < products.length; i++) {
                let p = products[i];
                let imgSrc = p.changeName 
                    ? '${pageContext.request.contextPath}/resources/upload/' + p.changeName 
                    : '${pageContext.request.contextPath}/resources/images/no-image.png';
                let price = (p.price || 0).toLocaleString();
                
                html += '<a href="${pageContext.request.contextPath}/productDetail?productNo=' + p.productNo + '">';
                html += '<div class="product-card">';
                html += '<img src="' + imgSrc + '" alt="' + p.productName + '">';
                html += '<h4>' + p.productName + '</h4>';
                html += '<p>₩' + price + '</p>';
                html += '</div></a>';
            }
            $("#productList").html(html);
        },
        error: function() {
            $("#productList").html('<p>상품을 불러올 수 없습니다.</p>');
        }
    });
}

$(document).ready(function() {
    loadCategories();
});
</script>
</body>
</html>