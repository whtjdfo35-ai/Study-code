package kr.or.human4.dao;

import java.util.List;
import java.util.Map;

import kr.or.human4.dto.EmpDTO;

public interface EmpDAO {
	
	List<EmpDTO> selectAllEmp();
	public EmpDTO selectOneEmp();
	public Map selectOneEmpMap();

	public EmpDTO selectEmpno(int empno);
	public List selectEname(String ename);
	public List selectJob(String job);
	List selectJobEname(EmpDTO dto);

	int insertEmp2(EmpDTO dto);
	int updateEmp2(EmpDTO dto);
	int deleteEmp2(int empno);
	EmpDTO login(EmpDTO dto);
	
	List search(EmpDTO dto);
	List choice(EmpDTO dto);
}
