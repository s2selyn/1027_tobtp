<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>상품 등록</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f4f6f9;
      font-family: 'Noto Sans KR', sans-serif;
      display: flex;
      justify-content: center;
      align-items: flex-start;
      min-height: 100vh;
      padding: 60px 15px;
    }

    .product-form {
      background: #fff;
      border-radius: 16px;
      box-shadow: 0 10px 30px rgba(0,0,0,0.1);
      padding: 40px 45px;
      width: 100%;
      max-width: 700px;
      animation: fadeIn 0.6s ease;
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }

    h2 {
      text-align: center;
      font-weight: 700;
      color: #333;
      margin-bottom: 35px;
    }

    label {
      font-weight: 600;
      margin-bottom: 8px;
      color: #444;
    }

    .form-control, .form-select {
      border-radius: 10px;
      padding: 12px 15px;
      font-size: 1rem;
      border: 1px solid #ddd;
      transition: all 0.3s ease;
    }

    .form-control:focus, .form-select:focus {
      border-color: #667eea;
      box-shadow: 0 0 0 3px rgba(102,126,234,0.2);
    }

    textarea {
      resize: none;
    }

    .btn-submit {
      width: 100%;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      border: none;
      padding: 14px 0;
      font-weight: 600;
      font-size: 1.1rem;
      border-radius: 10px;
      margin-top: 25px;
      transition: all 0.3s ease;
    }

    .btn-submit:hover {
      transform: translateY(-2px);
      box-shadow: 0 10px 25px rgba(102,126,234,0.4);
    }

    .preview {
      width: 100%;
      max-height: 250px;
      border-radius: 10px;
      object-fit: cover;
      margin-top: 10px;
      display: none;
      border: 1px solid #ccc;
    }
  </style>
</head>
<body>

  <form method="post" action="/spring/product" class="product-form" id="productForm" enctype="multipart/form-data">
    <h2>상품 등록</h2>

    <div class="mb-3">
      <label for="productName" class="form-label">상품명</label>
      <input type="text" id="productName" name="productName" class="form-control" placeholder="상품명을 입력하세요" required>
    </div>

    <div class="mb-3">
      <label for="price" class="form-label">가격 (₩)</label>
      <input type="number" id="price" name="price" class="form-control" placeholder="예: 15000" required>
    </div>

    <div class="mb-3">
      <label for="category" class="form-label">카테고리</label>
      <select id="category" name="categoryNo" class="form-select" required>
        <option value="">카테고리를 선택하세요</option>
        <option value="1">모자</option>
        <option value="2">상의</option>
        <option value="3">하의</option>
        <option value="4">신발</option>
        <option value="5">기타</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="color" class="form-label">색상</label>
      <select id="color" name="color" class="form-select" required>
        <option value="">색상을 선택하세요</option>
        <option value="블랙">블랙</option>
        <option value="화이트">화이트</option>
        <option value="그레이">그레이</option>
        <option value="베이지">베이지</option>
        <option value="네이비">네이비</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="description" class="form-label">상품 설명</label>
      <textarea id="description" name="detailContent" class="form-control" rows="5" placeholder="상품 설명을 입력하세요" required></textarea>
    </div>

    <div class="mb-3">
      <label for="image" class="form-label">상품 이미지 (1장)</label>
      <input type="file" id="image" name="upfile" class="form-control" accept="image/*" onchange="previewImage(event)" required>
      <img id="preview" class="preview" alt="상품 이미지 미리보기">
    </div>

    <div class="mb-3">
      <label for="seller" class="form-label">판매자</label>
      <input type="text" id="seller" name="memberName" class="form-control" value="StyleKing" readonly>
    </div>

    <button type="submit" class="btn-submit">상품 등록하기</button>
  </form>

  <script>
    // 이미지 미리보기
    function previewImage(event) {
      const preview = document.getElementById('preview');
      const file = event.target.files[0];
      if (file) {
        preview.src = URL.createObjectURL(file);
        preview.style.display = 'block';
      } else {
        preview.style.display = 'none';
      }
    }

    // 폼 제출 시 처리 (백엔드 연동 전용)
    /*
    document.getElementById('productForm').addEventListener('submit', (e) => {
      e.preventDefault();
      const formData = new FormData(e.target);
      alert("✅ 상품이 성공적으로 등록되었습니다!");
      console.log("등록 데이터:", Object.fromEntries(formData.entries()));
    });
    */
  </script>

</body>
</html>
