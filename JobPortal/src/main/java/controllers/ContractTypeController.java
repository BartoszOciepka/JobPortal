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

import models.ContractType;
import models.ContractTypeDao;
@Controller
@RequestMapping("/contracttype")
public class ContractTypeController {

	@Autowired
	ContractTypeDao contractTypeDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	String listContractTypes(Model model) {
		model.addAttribute("contractTypes", contractTypeDao.findAll());
		return "listContractTypes";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteContractType(@PathVariable(value = "id")Long id) {
		contractTypeDao.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addContractType(Model model) {
		model.addAttribute("contractType", new ContractType());
		return "addContractType";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addContractType(@ModelAttribute("contractType")@Valid ContractType contractType, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addContractType";
		}
		else {
			if(checkDuplicateValue(contractType)) {
				model.addAttribute("contractTypeError", "Duplicate values are illegal");
				return "addContractType";
			}
			contractTypeDao.save(contractType);
			return "redirect:/";
		}
	}
	
	public boolean checkDuplicateValue(ContractType contractType) {
		if(!contractTypeDao.findByTypeIgnoreCase(contractType.getType()).isEmpty()) return true;
		return false;
	}
}
