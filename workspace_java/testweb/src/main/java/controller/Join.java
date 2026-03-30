package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDTO.UserDTO;
import userService.UserService;

@WebServlet("/join")
public class Join extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		// 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");

		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id: " + id);
		// DTO에 넣기
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setPw(pw);
		
		// service로 DTO를 보냄
		UserService userservice = new UserService();
		int result = userservice.addUser(userDTO);
		
		response.sendRedirect("/proj03_1_todo/todo");
	}
	

}
