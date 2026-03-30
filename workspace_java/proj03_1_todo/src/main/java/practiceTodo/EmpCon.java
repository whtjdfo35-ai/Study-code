package practiceTodo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practiceTodo.EmpDTO;
import practiceTodo.EmpService;

@WebServlet("/empcon")
public class EmpCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");
		
		EmpService empService = new EmpService();
		List<EmpDTO> list = empService.getList();
		
		request.setAttribute("empList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Emp.jsp");
		rd.forward(request, response);
		
//		PrintWriter out = response.getWriter();
//		for(int i=0 ; i<list.size(); i++) {
//			out.println(list.get(i));
//		}
//		out.println(list.size());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
