package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Company;
import models.CompanyDao;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyDao companyDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	String listCompanies(Model model) {
		model.addAttribute("companies", companyDao.findAll());
		return "listCompanies";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteCompany(@PathVariable(value = "id") Long id) {
		companyDao.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompany(Model model) {
		model.addAttribute("company", new Company());
		return "addCompany";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(@ModelAttribute("company") @Valid Company company, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addCompany";
		} else {
			companyDao.save(company);
			return "redirect:/";
		}
	}

}
