package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {

	@Email
	@NotBlank
	@Column
	String companyEmail;

	@Id
	@GeneratedValue
	Long id;

	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<JobOffer> jobOffers;
	@Column
	String name;

	public String getCompanyEmail() {
		return companyEmail;
	}

	public Long getId() {
		return id;
	}

	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public String getName() {
		return name;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	public void setName(String name) {
		this.name = name;
	}
}
