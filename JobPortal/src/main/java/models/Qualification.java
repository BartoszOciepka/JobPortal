package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Qualification {

	@Id
	@GeneratedValue
	Long id;
	@ManyToMany(mappedBy="qualifications")
	List<JobOffer> jobOffers;
	@NotBlank
	@Column
	String name;
	public Long getId() {
		return id;
	}
	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}
	public String getName() {
		return name;
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
	@Override
	public String toString() {
		return name;
	}
}
