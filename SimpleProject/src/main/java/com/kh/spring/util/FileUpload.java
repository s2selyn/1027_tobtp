package com.kh.spring.util;

// @Component 나중에 빈등록하기
public class FileUpload {
	
	// 이 메소드를 호출하면 파일을 업로드하고 파일 정보를 반환?
	public FileInfo getFileInfo() {
		
		// 매개변수로 원본파일 정보 + 파일 자체를 받고
		
		// 파일 이름 바꿔주고
		
		// 파일 업로드 메소드 호출해서 업로드하고
		// 그럼 파일 업로드는 따로 메소드를 만들어서 책임분리해야함?
		// 아니면 거꾸로 업로드 메소드를 먼저 호출하는걸로 하고 그 메소드 내부에서 파일 이름 변경 메소드를 호출? 
		
		return new FileInfo();
		
	}
	
}
