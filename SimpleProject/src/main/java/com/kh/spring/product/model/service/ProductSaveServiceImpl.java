package com.kh.spring.product.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.exception.InvalidArgumentsException;
import com.kh.spring.product.model.dao.ProductSaveMapper;
import com.kh.spring.product.model.dto.ProductSaveDTO;
import com.kh.spring.util.FileInfo;
import com.kh.spring.util.FileUpload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSaveServiceImpl implements ProductSaveService {
	
	private final ProductSaveMapper productSaveMapper;
	private final FileUpload fileUpload;
	
	@Override
	public int save(ProductSaveDTO product, MultipartFile upfile, HttpSession session) {
		
		// 1_1) 권한 검증 : product에서 memberNo 받아오기
//		int productSaveWriter = product.getMemberNo();
		
		// 1_2) 로그인한 사용자 확인 -> Member 메소드 작업한분께 받아서 풀어야함
//		MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
		
//		if(loginMember == null) {
//			throw new NullPointerException("로그인이 필요한 기능입니다.");
//		}
		
		// 1_3) 로그인한 사용자의 memberNo 가져오기
//		int memberNo = loginMember.getMemberNo();
		
		// 1_4) 로그인한 사용자와 상품등록자가 같은지 확인
//		if(!productSaveWriter.equals(memberNo)) {
//			throw new AuthenticationException("상품 등록 권한이 없습니다. 관리자에게 문의하세요.");
//		}
		
		// 2. 값에 대한 유효성 검증
		// 상품명, 가격, 카테고리 번호, 판매자번호(위에서 받아옴), 상품설명, 파일이 있다면 이름 변경
		// 2_1) 상품명, 상품설명 확인
//		if(product.getProductName().trim().isBlank() || product.getDetailContent().trim().isBlank()) {
//			throw new InvalidArgumentsException("상품 정보를 올바르게 입력해주세요");
//		}
		// 책임분리함
		validateContent(product);
		
		// 2_2) 가격을 올바로 입력했는지 -> 이거 해야하는지? 넘어올때 이미 숫자인지 아닌지 확인이 되나..?
		// product.getPrice();
		
		// 2_3) 카테고리 번호 입력이 올바른지 -> 앞단에서 select 태그에서 넘어오는데 맞는지 확인해야하는가? 카테고리 두종류인데 이건 어떻게 함?
		// product.getCategoryNo();
		
		// 파일 업로드 성공 시 product에 정보 넣기 -> 파일이 없다면 굳이 저장 안해도 되니까 여기를 먼저해야함 -> 위로 갖고 올라왔음
		if(upfile != null && !upfile.isEmpty()) {
			
			FileInfo fileInfo = fileUpload.saveFile(upfile, session);
			if(fileInfo != null) {
				
				product.setFileOriginName(fileInfo.getFileOriginName());
				product.setChangeName(fileInfo.getFilePath());
				
			}
			
		}
		
		// 2_4) 파일이 있는지 확인
//		if(!upfile.getOriginalFilename().isBlank()) {
//			
//			// 2_5) 파일 이름 변경 -> 임의로 규칙 만들었습니다.
//			StringBuilder sb = new StringBuilder();
//			sb.append("Orange_");
//			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			sb.append(currentTime);
//			sb.append("_");
//			int num = (int)(Math.random() * 900) + 100;
//			sb.append(num);
//			String ext = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
//			sb.append(ext);
//			
//			ServletContext application = session.getServletContext();
//			String savePath = application.getRealPath("resources/files/");
//			// 임의로 파일 하나 넣어둠
//			
//			try {
//				upfile.transferTo(new File(savePath + sb.toString()));
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			// 업로드 성공했다면
//			product.setFileOriginName(upfile.getOriginalFilename());
//			
//			// full 경로
//			product.setChangeName("/spring/resources/files/" + sb.toString());
//			// context root 바뀌면 /spring 여기도 바뀌어야함 -> 이거 어떻게 얻더라...? -> session에 참조해서 getServletContext();
//			// ServletContext application = session.getServletContext();
//			// String savePath = application.getRealPath("/resources/files/");
//			
//		}
		// 책임분리함 -> FileInfo는 빈등록 안해두 되나..? 그냥 VO라서?
//		FileInfo fileInfo = fileUpload.saveFile(upfile, session);
		
		// -------------------------------------------------- 사실 1부터 2까지는 전부 책임분리해야함
		
		// 3. insert 하러 Mapper에 보냄
		int result = productSaveMapper.save(product);
		
		// 4. insert에 실패하면 예외 발생시키기
		if(result != 1) {
			throw new RuntimeException("일단 insert에 실패했다는데 예외는 안만들었습니다.");
		}
		
		// 5. 결과 반환하기
		return result;
		
	}
	
//	// 나중에 병합하고 써먹을 사용자 검증도 미리 작성
//	private void validateUser(ProductSaveDTO product, HttpSession session) {
//		
//		int productSaveWriter = product.getMemberNo();
//		
//		MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
//		
//		if(loginMember == null) {
//			throw new NullPointerException("로그인이 필요한 기능입니다.");
//		}
//
//		int memberNo = loginMember.getMemberNo();
//		
//		if(!productSaveWriter.equals(memberNo)) {
//			throw new AuthenticationException("상품 등록 권한이 없습니다. 관리자에게 문의하세요.");
//		}
//		
//	}
	
	// 값에 대한 유효성 검증 메소드로 책임분리 -> DTO 받아와서 안에 든것 제대로인지 확인
	private void validateContent(ProductSaveDTO product) {
		
		// 비어있는지 확인
		if(product.getProductName().trim().isBlank() || product.getDetailContent().trim().isBlank()) {
			throw new InvalidArgumentsException("상품 정보를 올바르게 입력해주세요");
		}
		
		// 태그 인식하지 않게 필터링
		String productName = product.getProductName().replaceAll("<", "&lt;"); // 상품명 필터링
		String detailContent = product.getDetailContent().replaceAll("<", "&lt;"); // 상품상세 필터링
		
		product.setProductName(productName);
		product.setDetailContent(detailContent);
		
	}

}
