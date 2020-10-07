package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	
	void excute(HttpServletRequest request, HttpServletResponse response);
	
	}





/*
 * 인터페이스 특징 => 추상 메서드만 들어간다 : 정의되지 않은(미완성) 메서드
 * 
 * 추상 클래스, interface 차이
 */
