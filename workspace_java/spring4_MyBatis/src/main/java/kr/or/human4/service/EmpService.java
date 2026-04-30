package kr.or.human4.service;

import java.util.List;
import java.util.Map;

import kr.or.human4.dto.EmpDTO;

public interface EmpService {

	List<EmpDTO> getEmpList();
	EmpDTO getEmp();
	Map getEmpMap();
	
	EmpDTO getEmpno(int empno);
	List getEname(String ename);
	List getJob(String job);
	List getJobEname(EmpDTO dto);

	int joinEmp2(EmpDTO dto);
	int modifyEmp2(EmpDTO dto);
	int removeEmp2(int empno);

	EmpDTO loginCheck(EmpDTO dto);
	
	List<EmpDTO> search(EmpDTO dto);
	List<EmpDTO> choice(EmpDTO dto);
}
