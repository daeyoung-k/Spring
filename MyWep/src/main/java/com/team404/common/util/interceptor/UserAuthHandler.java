package com.team404.common.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

// 들어오는 요청을 가로채서 
// 회원페이지 관련된 요청이 들어왔을때 요청을 가로체서 처리할 인터셉터,  핸들링 해줄 pre핸들러 인터셉터
public class UserAuthHandler extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 세션에서 userVO값을 얻는다.
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");  // 없으면 null
		
		if(userVO == null) {  // 로그인이 안된 시점
			
			response.sendRedirect(request.getContextPath() + "/user/userLogin");  // 로그인페이지로 보냄
			
			return false;   // 컨트롤러를 실행하지 않는다.
		}else {   // 로그인이 된 시점
			
			return true;  // 컨트롤러로 보내는 것
		}
		
	}
	
}
