package emp_mst;

import java.util.List;

public class Emp_mstService {
	private Emp_mstDAO dao = new Emp_mstDAO();

	public List<Emp_mstDTO> getEmpList() {
		return dao.getEmpList();
	}
}
