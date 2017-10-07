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

import models.JobOffer;
import models.Qualification;
import models.QualificationDao;

@Controller
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	QualificationDao qualificationDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String ViewAddQualification(Model model) {
		Qualification qualification = new Qualification();
		model.addAttribute("qualification", qualification);
		return "addQualification";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addQualification(@ModelAttribute("qualification")@Valid Qualification qualification, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "addQualification";
		}
		System.out.println(qualification.getName());
		qualificationDao.save(qualification);
		return "addQualification";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQualification(@PathVariable("id") Long id) {
		Qualification qualification = qualificationDao.findOne(id);
		qualificationDao.delete(qualification);
		return "redirect:/qualification/add";
	}
}
