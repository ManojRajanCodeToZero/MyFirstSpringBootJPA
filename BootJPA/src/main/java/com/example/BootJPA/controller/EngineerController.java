package com.example.BootJPA.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.BootJPA.dao.EngineerRepo;
import com.example.BootJPA.model.Engineer;

@RestController
public class EngineerController implements ErrorController {
	public static String error = null;
	@Autowired
	EngineerRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	/*
	 * @RequestMapping("/addEngineer") public ModelAndView addEngineer(Engineer
	 * engineer) { ModelAndView mv = new ModelAndView(); try { repo.save(engineer);
	 * System.out.println("ADDED!!" + engineer.getEid());
	 * mv.setViewName("home.jsp"); } catch (Exception e) { error =
	 * engineer.toString(); mv.setViewName("errotPage.jsp");
	 * mv.addObject("Exception", e); } return mv; }
	 */

	@RequestMapping("/displayEngineer")
	public ModelAndView displayEngineer(@RequestParam int eid) {

		/* To get a Specific Eid */

		ModelAndView mv = new ModelAndView("display.jsp");
		Engineer engineer = repo.findById(eid).orElse(new Engineer());
		mv.addObject(engineer);
		return mv;

		/* To get all the records */
		/*
		 * ModelAndView mv = null; List<Engineer> engineer = (List<Engineer>)
		 * repo.findAll(); mv = new ModelAndView("display.jsp", "Engineer", engineer);
		 * return mv ;
		 */

	}

	/*
	 * @RequestMapping("/deleteEngineer") public ModelAndView
	 * deleteEngineer(@RequestParam int eid) {
	 * 
	 * /* To get a Specific Eid
	 */

	/*
	 * Engineer engineer = repo.findById(eid).orElse(new
	 * Engineer());repo.delete(engineer); ModelAndView mv = null; List<Engineer>
	 * engineers = (List<Engineer>) repo.findAll();mv=new
	 * ModelAndView("display.jsp","Engineer",engineers);return mv;
	 * 
	 * }
	 */

	@RequestMapping("/gotoSortedEngineer")
	public ModelAndView gotoSortedEngineer(@RequestParam String eLang) {
		ModelAndView mv = null;
		List<Engineer> engineer = repo.findByeLang(eLang);
		mv = new ModelAndView("display.jsp", "Engineer", engineer);
		return mv;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub1
		return "/error";
	}

	@RequestMapping("/error")
	@ResponseBody
	public String handleError(HttpServletRequest request) {

		String eId = request.getParameter("eid");
		String eName = request.getParameter("eName");
		String eLang = request.getParameter("eLang");
		return "<h1> EID: " + eId + "<h1>" + "<h1> ENAME: " + eName + "<h1>" + "<h1>ELANG: " + eLang + " <h1>"
				+ "<h1>Are not a valid Entry!<h1>";
	}

	/* To POST an Engineer */
	@PostMapping("/addEngineer")
	public Engineer addEngineer(Engineer engineer) {
		repo.save(engineer);
		return engineer;
	}

	@DeleteMapping("engineer/{eid}")
	public Engineer deleteEngineer(@PathVariable int eid) {
		Engineer e = repo.getOne(eid);
		repo.delete(e);
		return e;
	}

	@PutMapping("/engineer")
	public Engineer uppdateEngineer(Engineer e) {
		repo.save(e);
		return e;
	}

	/** To return all the content */
	@RequestMapping(path = "/engineers")
	@ResponseBody
	public List<Engineer> getAllEngineers() {
		return repo.findAll();
	}

	/** to return Specific Eid */
	@RequestMapping(path = "/engineer/{eid}", produces = { "application/xml" })
	@ResponseBody
	public Optional<Engineer> getEngineer(@PathVariable("eid") int eid) {
		return repo.findById(eid);
	}
}
