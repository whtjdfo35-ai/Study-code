package userService;

import java.util.List;

import userDTO.UserDTO;
import userDAO.UserDAO;

public class UserService {
	public List getList() {
		
		UserDAO userDAO = new UserDAO();
		return userDAO.selectAll();
	}
	
	public UserDTO getuser(String id) {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.selectOne(id);
		return userDTO;
	}
	
	
	public int addUser(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();
		return userDAO.insertUser(userDTO);	
	} 
//	
//	public int update(UserDTO dto) {
//		UserDAO userDAO = new UserDAO();
//		int count = userDAO.updateuser(dto);
//		return count;
//	}
//	
//	public int delete(UserDTO dto) {
//		UserDAO userDAO = new UserDAO();
//		return userDAO.deleteuser(dto);
//	}
}
