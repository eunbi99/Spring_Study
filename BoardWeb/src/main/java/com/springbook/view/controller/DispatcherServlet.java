package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//1.클라이언트 요청 path 정보를 추출
		String uri= request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/")); // 마지막의 "/"를 기준으로 자르겠다. ex)xxx.do
		
		
		//2.HandlerMapping을 통해 path에 해당하는 Controller 검색
		//HandlerMapping에 맞는 controller를 ctrl에 담아서 실행한다.
		Controller ctrl = handlerMapping.getController(path);
		
		//3.검색된 Controller 실행
		//실행한다음 결과에 맞는 페이지는 viewName에 담는다.
		String viewName = ctrl.handleRequest(request, response);
		
		
		//4. ViewResolver를 통해 viewName에 해당하는 화면 검색.
		//viewName에  . do가 포함되지 않았다면 /xx.do로 보내고
		String view=null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			//.login.do
		}else {
			//붙어있다면 그대로  view에 담는다.
			view = viewName;
		}
		
		//5.검색된 화면으로 이동
		response.sendRedirect(view);
		//로그인 성공시 getboardlist.do로 실행
		//.do로 호출시 dispatcher로 와서 request로 받아들여 doGet함수로 이동 
	
		
	}
}
