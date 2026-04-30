package kr.or.human4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.human4.dto.EmpDTO;
import kr.or.human4.service.EmpService;

@Controller
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("/list 실행");
		
		List<EmpDTO> list = empService.getEmpList();
		System.out.println("/list: list: "+ list);
		
//		return "emp";
		model.addAttribute("list", list);
		return "result";
	}

	@RequestMapping("/one")
	public String one() {
		System.out.println("/one실행");
		
		EmpDTO empDTO = empService.getEmp();
		System.out.println("/one: empDTO: "+ empDTO);
		
		return "emp";
	}
	@RequestMapping("/oneMap")
	public String oneMap() {
		System.out.println("/oneMap실행");
		
		Map map = empService.getEmpMap();
		System.out.println("/oneMap: map: "+ map);
		
		return "emp";
	}

	@RequestMapping("/getEmpno")
	public String getEmpno(Model model,
			@RequestParam(value="empno", required=false)
			int empno
	) {
		System.out.println("/getEmpno 실행");
		
		System.out.println("empno: "+ empno);
		EmpDTO empDTO = empService.getEmpno(empno);

		model.addAttribute("empDTO", empDTO);
		
		return "result";
	}

//	boolean isDebug = false;
	int debugLevel = 1;
	
	@RequestMapping("/getEname")
	public String getEname(Model model,
			String ename
	) {
//		if(isDebug) {
		if(debugLevel > 3) {
			System.out.println("/getEmpno 실행");
		}
		
		System.out.println("ename: "+ ename);
		
		logger.info("info:/getEmpno 실행");
		logger.warn("warn:ename: "+ ename);
		logger.error("error:ename: "+ ename);
		
		List list = empService.getEname(ename);
		System.out.println("list: "+ list);
		
		model.addAttribute("list", list);
		
//		if(isDebug) {
		if(debugLevel > 3) {
			System.out.println("정상적으로 끝남");
		}
		return "result";
	}
	
	@RequestMapping("/getJob")
	public String getJob(Model model,
			String job
			) {
		System.out.println("/getJob 실행");
		
		logger.info("job: "+ job);
		
		List list = empService.getJob(job);
		System.out.println("list: "+ list);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	@RequestMapping("/getJobEname")
	public String getJobEname(Model model,
			EmpDTO empDTO
			) {
		System.out.println("/getJob 실행");
		
		logger.info("job: "+ empDTO);
		
		List list = empService.getJobEname(empDTO);
		System.out.println("list: "+ list);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}
	@RequestMapping("/joinEmp2")
	public String joinEmp2(Model model,
			EmpDTO empDTO
	) {
		System.out.println("/joinEmp2 실행");
		
		logger.info("empDTO: "+ empDTO);
		
		int result = empService.joinEmp2(empDTO);
		
		if(result < 1) {
			model.addAttribute("msg", "가입 안됨");
			model.addAttribute("msg_code", "1");
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			int empno
	) {
		System.out.println("/detail 실행");
		
		System.out.println("empno: "+ empno);
		EmpDTO empDTO = empService.getEmpno(empno);

		model.addAttribute("empDTO", empDTO);
		
		return "detail";
	}
	@RequestMapping(value="/modify/{empno}", method=RequestMethod.GET)
	public String modify(Model model,
			@PathVariable
			int empno
	) {
		System.out.println("[GET] /modify 실행");
		
		System.out.println("empno: "+ empno);
		EmpDTO empDTO = empService.getEmpno(empno);
		
		model.addAttribute("empDTO", empDTO);
		
		return "modify";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Model model,
			EmpDTO dto
			) {
		System.out.println("[POST] /modify 실행");
		System.out.println("empDTO: "+ dto);
		
		int result = empService.modifyEmp2(dto);
		System.out.println("업데이트 결과: "+ result);
		
		return "redirect:/detail?empno="+dto.getEmpno();
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public String delete(Model model,
			@RequestBody EmpDTO empDTO
			) {
		System.out.println("[POST] /delete 실행");
		System.out.println("empDTO.getEmpno(): "+ empDTO.getEmpno());
		
		int result = empService.removeEmp2(empDTO.getEmpno());
		System.out.println("삭제 결과: "+ result);
		
		if(result > 0) {
			return "Y";
		} else {
			return "N";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			Model model,
			HttpServletRequest req,
			EmpDTO empDTO) {
		System.out.println("[POST] /delete 실행");
		System.out.println("empDTO: "+ empDTO);
		
		empDTO = empService.loginCheck(empDTO);
		System.out.println("로그인 결과 empDTO: "+ empDTO);
		
		String url = "redirect:/index.jsp";
		if(empDTO != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", empDTO);
			url = "redirect:/list";
		}
		return url;
	}

	@RequestMapping(value="/logout")
	public String login(
			Model model,
			HttpServletRequest req) {

		HttpSession session = req.getSession();
		session.invalidate();

		return "redirect:/list";
	}
	
	@RequestMapping("/search")
	public String search(Model model, 
			@ModelAttribute("empDTO")
			EmpDTO empDTO) {
		model.addAttribute("empDTO", empDTO);
		
		System.out.println("/search 실행");
		
		List<EmpDTO> list = empService.search(empDTO);
		System.out.println("/list: list: "+ list);
		
		model.addAttribute("list", list);
		return "result";
	}
	
	@RequestMapping("/choice")
	public String choice(Model model, EmpDTO empDTO) {
		model.addAttribute("empDTO", empDTO);
		System.out.println("empDTO : "+ empDTO);
		
		System.out.println("/choice 실행");
		
		List<EmpDTO> list = empService.choice(empDTO);
		System.out.println("/list: list: "+ list);
		
		model.addAttribute("list", list);
		return "result";
	}
}





