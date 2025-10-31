<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
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
		  color: white;       /* 글자 색상 */
    	  text-decoration: none; /* 밑줄 제거 */
    	  cursor: pointer;    /* 클릭 가능한 커서 */
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
    </style>

    
</head>
<body>

    <header class="header">
    <a href="/home" class="logo">
    	Thirty<br>Orange<br>Babies
	</a>

    <div class="search-container">
      <input type="text" placeholder="Search for anything..." />
      <button class="search-btn">🔍</button>
    </div>

    <div class="header-icons">
      <a href="#">Product</a>
      <a href="#">Review</a>
      <a href="#">Customer Support</a>
      <a href="#">Need Help</a>
      <div class="icons">
        🛒
      </div>
    </div>
  </header>
</body>
</html>