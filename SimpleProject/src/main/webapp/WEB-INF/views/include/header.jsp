<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Thirty Orange Babies</title>
  <link rel="stylesheet" href="styles.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  
  <style>
  	* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Inter', sans-serif;
}

body {
  background-color: #fff;
  color: #333;
}

/* HEADER */
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #ff9240;
  padding: 1rem 2rem;
  color: white;
}

.logo {
  font-weight: 700;
  font-size: 1.3rem;
  line-height: 1.2;
}

.search-container {
  flex: 1;
  max-width: 600px;
  display: flex;
  margin: 0 2rem;
}

.search-container input {
  flex: 1;
  padding: 0.6rem;
  border: none;
  border-radius: 4px 0 0 4px;
  outline: none;
}

.search-btn {
  background: white;
  border: none;
  border-radius: 0 4px 4px 0;
  padding: 0.6rem 1rem;
  cursor: pointer;
}

.header-icons {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.header-icons a {
  color: white;
  text-decoration: none;
  font-weight: 500;
  font-size: 0.95rem;
}

.category-dropdown {
  border: none;
  padding: 0.4rem;
  border-radius: 4px;
  background: white;
  color: #333;
}

/* MAIN */
.main {
  display: flex;
  padding: 2rem;
  gap: 2rem;
}

/* Sidebar */
.sidebar {
  width: 180px;
}

.sidebar ul {
  list-style: none;
}

.sidebar li {
  padding: 0.8rem;
  cursor: pointer;
  border-radius: 6px;
  margin-bottom: 0.3rem;
  transition: 0.3s;
}

.sidebar li:hover,
.sidebar li.active {
  background-color: #ff9240;
  color: white;
}

/* Product Section */
.product-section {
  flex: 1;
}

.product-section h2 {
  margin-bottom: 1rem;
  font-size: 1.2rem;
  font-weight: 600;
}

.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 1.5rem;
}

.product-card {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 1rem;
  text-align: center;
  transition: 0.3s;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.product-info {
  margin-top: 0.5rem;
}

.product-name {
  font-weight: 600;
  margin-bottom: 0.3rem;
}

.product-price {
  color: #007aff;
  font-weight: 600;
}

.rating {
  color: #ff9240;
  font-size: 0.9rem;
}

/* FOOTER */
.footer {
  background-color: #333;
  color: white;
  padding: 2rem;
  text-align: left;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
}

.footer h2 {
  color: #ff9240;
  margin-bottom: 0.8rem;
}

.footer p {
  font-size: 0.9rem;
  line-height: 1.5;
  margin-bottom: 0.8rem;
}

.footer small {
  display: block;
  text-align: right;
  margin-top: 1rem;
  color: #aaa;
  font-size: 0.8rem;
}
  </style>
</head>
<body>
  <!-- HEADER -->
  <header class="header">
    <div class="logo">Thirty<br>Orange<br>Babies</div>

    <div class="search-container">
      <input type="text" placeholder="Search for anything..." />
      <button class="search-btn">🔍</button>
    </div>

    <div class="header-icons">
      <select class="category-dropdown">
        <option>Category</option>
      </select>
      <a href="#">Review</a>
      <a href="#">Compare</a>
      <a href="#">Customer Support</a>
      <a href="#">Need Help</a>
      <a href="#loginModal">Login</a>
      <a href="/spring/join">Sign Up</a>
      <div class="icons">
        🛒
      </div>
    </div>
  </header>
  
<body>


  <!-- MAIN -->
  <main class="main">
    <aside class="sidebar">
      <ul>
        <li class="active">Menu1</li>
        <li>Menu2</li>
        <li>Menu3</li>
        <li>Menu4</li>
        <li>Menu5</li>
        <li>Menu6</li>
        <li>Menu7</li>
        <li>Menu8</li>
        <li>Menu9</li>
        <li>Menu10</li>
      </ul>
    </aside>

    <section class="product-section">
      <h2>ALL PRODUCT</h2>
      <div class="product-grid">
        <!-- 상품 카드 반복 -->
        <div class="product-card">
          <img src="https://via.placeholder.com/200x150" alt="Product" />
          <div class="product-info">
            <p class="product-name">DELL 21.5 inch Full HD Monitor (E2216HV)</p>
            <p class="product-price">500,000원</p>
            <p class="rating">★★★★★ (56,767)</p>
          </div>
        </div>

        <!-- 복사 -->
        <div class="product-card">
          <img src="https://via.placeholder.com/200x150" alt="Product" />
          <div class="product-info">
            <p class="product-name">DELL 21.5 inch Full HD Monitor (E2216HV)</p>
            <p class="product-price">500,000원</p>
            <p class="rating">★★★★★ (56,767)</p>
          </div>
        </div>
      </div>
    </section>
  </main>

    <!-- 로그인 클릭 시 뜨는 모달 -->
    <div class="modal fade" id="loginModal">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Login</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
        
                <form action="/spring/login" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <label for="memberId" class="mr-sm-2">ID : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter ID" id="memberId" name="memberId"> <br>
                        <label for="memberPwd" class="mr-sm-2">Password : </label>
                        <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="memberPwd" name="memberPwd">
                    </div>
                           
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">로그인</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
    
    <br clear="both">
</body>
</html>