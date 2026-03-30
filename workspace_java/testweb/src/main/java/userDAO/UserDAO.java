package userDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import userDTO.UserDTO;

public class UserDAO {
	public List<UserDTO> selectAll() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// DB 접속
			conn = dataFactory.getConnection();

			// SQL 준비
			String query = "select * from userInfo";
			ps = conn.prepareStatement(query);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {

				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int tel = rs.getInt("tel");

				UserDTO userDTO = new UserDTO();
				userDTO.setId(id);
				userDTO.setPw(pw);
				userDTO.setTel(tel);

				list.add(userDTO);
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

	public UserDTO selectOne(String id) {

		UserDTO userDTO = new UserDTO();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

			// SQL 준비
			String query = "select * from userInfo where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			if (rs.next()) {
				userDTO.setId(rs.getString("id"));
				userDTO.setPw(rs.getString("pw"));
				userDTO.setTel(rs.getInt("tel"));
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
		return userDTO;
	}

	public int insertUser(UserDTO userDTO) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 절대 안나오는 값 넣기
		int result = -1;

		try {
			
			Context ctx = new InitialContext();			
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

			// SQL 준비			
			String query = " insert into user ";
			query += " values(seq_user.nextval, ?, ?, 0)"; // 변수 방식
			ps = conn.prepareStatement(query);
			ps.setString(1, userDTO.getId());
			ps.setString(2, userDTO.getPw());

			// SQL 실행 및 결과 확보 (영향받은 줄 수 나옴 )
			result = ps.executeUpdate();
			System.out.println("insert 결과 :" + result);

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
		return result;
	}

}
