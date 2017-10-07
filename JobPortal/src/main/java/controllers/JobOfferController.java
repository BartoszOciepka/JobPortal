package controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import models.JobOffer;
import models.JobOfferDao;
import models.Qualification;
import models.QualificationDao;
import models.Search;

@SessionAttributes("qualifications")
@Controller
@RequestMapping("/offer")
public class JobOfferController {

	@Autowired
	Search search;

	@Autowired
	JobOfferDao jobOfferDao;

	@Autowired
	QualificationDao qualificationDao;

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addOffer(Model model) {
		model.addAttribute("jobOffer", new JobOffer());
		return "addOffer";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addOffer(@ModelAttribute("jobOffer")@Valid JobOffer jobOffer, BindingResult result) {
		if(result.hasErrors()) return "addOffer";
		else {
			jobOfferDao.save(jobOffer);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteJobOffer(@PathVariable(value="id")Long id) {
		jobOfferDao.delete(id);
		return "redirect:/";
	}

	@ModelAttribute("qualifications")
	public List<Qualification> initializeQualifcations() {
		return qualificationDao.findAll();
	}
}
