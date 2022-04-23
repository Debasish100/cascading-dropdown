package com.example.demo.MainController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.MainEntity.Country;

import com.example.demo.MainService.CountryService;
import com.example.demo.MainService.StateService;

@Controller
public class ProjectController {

	@Autowired
	CountryService cserv;

	@Autowired
	StateService sserv;

	@Autowired
	HttpSession session;

	@GetMapping("/")
	public String home(Model model, Country country) {
		List<Country> clist = new ArrayList<Country>();

		try {

			clist = cserv.getCountryList();
			model.addAttribute("country", new Country());

			model.addAttribute("clist", clist);

		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}

		return "Dropdown";
	}

	@ResponseBody

	@PostMapping(value = "/listofState")
	public String getSchemelist(Model model, @RequestParam(value = "cname", required = true) String cname) {
		System.out.println("****" + cname);
		String state = sserv.listofstate(cname);

		return state;

	}

	

}
