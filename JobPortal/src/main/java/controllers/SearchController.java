package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.JobOffer;
import models.JobOfferDao;
import models.Search;

@Controller
@RequestMapping("/")
public class SearchController {

	@Autowired
	JobOfferDao jobOfferDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String search(Model model) {
		Search search = new Search();
		model.addAttribute("search", search);
		return "default";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String search(@ModelAttribute("search") Search search, BindingResult result, Model model) {
		List<JobOffer> jobOffers = jobOfferDao.findByNameContainingIgnoreCaseAndCityLikeIgnoreCase(search.getPhrase(), search.getCity());
		model.addAttribute("offers", jobOffers);
		return "default";
	}
}
