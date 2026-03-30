package practiceTodo;

import java.util.List;

import practiceTodo.EmpDAO;
import practiceTodo.EmpDTO;

public class EmpService {
	
	public List getList() {
		// empDAO의 selectAll을 호출하고 
		// 그 List를 return 해주세요 
		
		EmpDAO empDAO = new EmpDAO();
		return empDAO.selectAll();
	}
	
	
//	public EmpDTO getemp(int emp_id) {
//		EmpDAO empDAO = new EmpDAO();
//		EmpDTO empDTO = empDAO.selectOne(emp_id);
//		return empDTO;
//	}
//	
//	
//	public int addemp(EmpDTO empDTO) {
//		EmpDAO empDAO = new EmpDAO();
//		return empDAO.insertemp(empDTO);	
//	} 
//	
//	public int update(EmpDTO dto) {
//		EmpDAO empDAO = new EmpDAO();
//		int count = empDAO.updateemp(dto);
//		return count;
//	}
//	
//	public int delete(EmpDTO dto) {
//		EmpDAO empDAO = new EmpDAO();
//		return empDAO.deleteemp(dto);
//	}

}
