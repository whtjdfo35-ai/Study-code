package emp_mst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp_mst")
public class Emp_mstCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");

		Emp_mstService service = new Emp_mstService();
		List<Emp_mstDTO> list = service.getEmpList();
		
		PrintWriter out = response.getWriter();
		out.println(list.size());
		for (Emp_mstDTO dto : list) {
			out.println(dto);
		}
		
		out.println("<br>---------------------------<br>");
		for(int i=0; i<list.size(); i++) {
			out.println("<br>"+i+"  ");
			out.println("No : "+list.get(i).getNo());
			out.println("ItemsUnit : "+list.get(i).getItemsUnit());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
