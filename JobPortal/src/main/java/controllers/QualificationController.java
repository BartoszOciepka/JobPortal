package controllers;

import javax.validation.Valid;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import models.Qualification;
import models.QualificationDao;

@Controller
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	QualificationDao qualificationDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addQualification(Model model) {
		model.addAttribute("qualification", new Qualification());
		return "addQualification";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addQualification(@ModelAttribute("qualification")@Valid Qualification qualification, BindingResult result, Model model) {
		if(result.hasErrors()) return "addQualification";
		else {
			try {
				qualificationDao.save(qualification);
			}
			catch (Exception pex) {
				if(checkDuplicateValue(qualification)) {
					model.addAttribute("qualificationError", "Duplicate values are illegal");
					return "addQualification";	
				}
				model.addAttribute("errorMessage", pex.getMessage());
				return "error";
			}
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQualification(@PathVariable("id") Long id) {
		qualificationDao.delete(qualificationDao.findOne(id));
		return "redirect:/qualification/add";
	}
	
	public boolean checkDuplicateValue(Qualification qualification) {
		if(!qualificationDao.findByName(qualification.getName()).isEmpty()) return true;
		return false;
	}
}
