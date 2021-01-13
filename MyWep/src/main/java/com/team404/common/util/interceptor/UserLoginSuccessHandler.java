package com.team404.common.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

public class UserLoginSuccessHandler extends HandlerInterceptorAdapter{

	//로그인 이후에 실행되는 핸들러(PostHandler) 오버라이딩
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//login맵핑 컨트롤러에서는 ModelAndView를 반환합니다.
		//modelAnView객체에 있는 모델데이터가 map의 형식으로 반환
		ModelMap mv = modelAndView.getModelMap();		
		UserVO userVO = (UserVO) mv.get("login"); //model에 담겨있는 userVO를 꺼냅니다			
		
		if(userVO != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			response.sendRedirect(request.getContextPath());
		}
		
	}
	
	
	
}
