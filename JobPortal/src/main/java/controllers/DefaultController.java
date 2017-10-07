package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.JobOffer;
import models.JobOfferDao;
import models.Qualification;
import models.QualificationDao;
import models.Search;

@Controller
@RequestMapping("/")
public class DefaultController {

	@Autowired
	Search search;
	
	@Autowired
	JobOfferDao jobOfferDao;
	
	@Autowired
	QualificationDao qualificationDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("search", search);
		return "default";
	}
}
