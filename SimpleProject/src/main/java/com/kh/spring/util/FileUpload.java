package com.kh.spring.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // 나중에 빈등록하기
public class FileUpload {
	
	// 이 메소드를 호출하면 파일을 업로드하고 파일 정보를 반환?
	public FileInfo saveFile(MultipartFile upfile, HttpSession session) {
		// 매개변수로 원본파일 정보 + 파일 자체를 받고
		
		// 파일 이름 뽑아내기 -> 있다면 이름 변경 / 없다면 파일 없으니까 리턴
		String fileOriginName = upfile.getOriginalFilename();
		
		// 파일 이름 바꿔주고
		if(!fileOriginName.isBlank()) {
			
			String changeName = getChangeName(fileOriginName);

			// 서버에 파일 저장할 경로 설정
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("resources/files/");
			String filePath = "/spring/resources/files/" + changeName;
			// context root 바꿔서 여기안되는건가?
			
			try {
				
				// 파일 업로드 메소드 호출해서 업로드하고
				upfile.transferTo(new File(savePath + changeName));
				
				// 객체 만들어서 돌려보낼때 원본파일이름 + 실제경로 넣어서 반환
				return new FileInfo(fileOriginName, changeName, filePath);
				
			} catch(Exception e) {
				
				e.printStackTrace();
				throw new RuntimeException();
				// 파일 업로드 실패 예외 만들기
				
			}
			
		}
		
		return null;
		
	}
	
	// 파일이름 변경 메소드 분리
	private String getChangeName(String fileOriginName) {
		
		// 2_5) 파일 이름 변경 -> 임의로 규칙 만들었습니다.
		StringBuilder sb = new StringBuilder();
		sb.append("Orange_");
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		sb.append(currentTime);
		sb.append("_");
		int num = (int)(Math.random() * 900) + 100;
		sb.append(num);
		String ext = fileOriginName.substring(fileOriginName.lastIndexOf("."));
		sb.append(ext);
		
		return sb.toString();
		
	}
	
}
