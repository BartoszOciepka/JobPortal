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

import models.CompanyDao;
import models.ContractTypeDao;
import models.JobOffer;
import models.JobOfferDao;
import models.QualificationDao;
import models.Search;

@Controller
@RequestMapping("/offer")
public class JobOfferController {

	@Autowired
	Search search;

	@Autowired
	JobOfferDao jobOfferDao;

	@Autowired
	QualificationDao qualificationDao;
	
	@Autowired
	ContractTypeDao contractTypeDao;
	
	@Autowired
	CompanyDao companyDao;

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addOffer(Model model) {
		model.addAttribute("jobOffer", new JobOffer());
		model.addAttribute("qualifications", qualificationDao.findAll());
		model.addAttribute("contractTypes", contractTypeDao.findAll());
		model.addAttribute("companies", companyDao.findAll());
		return "addOffer";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addOffer(@ModelAttribute("jobOffer")@Valid JobOffer jobOffer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("qualifications", qualificationDao.findAll());
			model.addAttribute("contractTypes", contractTypeDao.findAll());
			model.addAttribute("companies", companyDao.findAll()); 
			return "addOffer";
		}
		else {
			jobOfferDao.save(jobOffer);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/show/{id}", method = RequestMethod.GET)
	public String showOffer(@PathVariable(value = "id")Long id, Model model) {
		model.addAttribute("jobOffer", jobOfferDao.findOne(id));
		return "showOffer";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteJobOffer(@PathVariable(value="id")Long id) {
		jobOfferDao.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listJobObbers(Model model) {
		model.addAttribute("jobOffers", jobOfferDao.findAll());
		return "listJobOffers";
	}
}
