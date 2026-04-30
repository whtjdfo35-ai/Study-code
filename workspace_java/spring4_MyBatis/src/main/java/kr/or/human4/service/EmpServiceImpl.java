package kr.or.human4.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human4.dao.EmpDAO;
import kr.or.human4.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> result = empDAO.selectAllEmp();
		
		return result;
	}

	@Override
	public EmpDTO getEmp() {
		EmpDTO empDTO = empDAO.selectOneEmp();
		return empDTO;
	}

	@Override
	public Map getEmpMap() {
		Map map = empDAO.selectOneEmpMap();
		return map;
	}

	@Override
	public EmpDTO getEmpno(int empno) {
		EmpDTO empDTO = empDAO.selectEmpno(empno);
		return empDTO;
	}
	@Override
	public List getEname(String ename) {
		List list = empDAO.selectEname(ename);
		return list;
	}
	@Override
	public List getJob(String job) {
		List list = empDAO.selectJob(job);
		return list;
	}
	@Override
	public List getJobEname(EmpDTO empDTO) {
		List list = empDAO.selectJobEname(empDTO);
		return list;
	}
	@Override
	public int joinEmp2(EmpDTO dto) {
		return empDAO.insertEmp2(dto);
	}

	@Override
	public int modifyEmp2(EmpDTO dto) {
		return empDAO.updateEmp2(dto);
	}

	@Override
	public int removeEmp2(int empno) {
		return empDAO.deleteEmp2(empno);
	}

	@Override
	public EmpDTO loginCheck(EmpDTO dto) {
		EmpDTO empDTO = empDAO.login(dto);
		return empDTO;
	}

	@Override
	public List<EmpDTO> search(EmpDTO dto) {
		List<EmpDTO> result = empDAO.search(dto);
		return result;
	}
	@Override
	public List<EmpDTO> choice(EmpDTO dto) {
		List<EmpDTO> result = empDAO.choice(dto);
		return result;
	}
}
