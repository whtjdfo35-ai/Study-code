package emp_mst;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class Emp_mstDAO {
	
	
    public List<Emp_mstDTO> getEmpList() {

        List<Emp_mstDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

	try {
		
		Context ctx = new InitialContext();
		DataSource dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		
		conn = dataFactory.getConnection();
		
		String query = "select * from emp";
		ps = conn.prepareStatement(query);		
		rs = ps.executeQuery();
		
		while (rs.next()) {			
			
			int no = rs.getInt("NO");
			String itemsUnit = rs.getString("ITEMSUNIT");
			Emp_mstDTO emp_mstDTO = new Emp_mstDTO();
			emp_mstDTO.setNo(no);
			emp_mstDTO.setItemsUnit(itemsUnit);
			list.add(emp_mstDTO);						
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	return list;
	}

}
