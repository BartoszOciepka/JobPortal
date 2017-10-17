package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ContractType {
	@GeneratedValue
	@Id
	Long id;

	@OneToMany(mappedBy = "contractType", fetch = FetchType.EAGER)
	private List<JobOffer> jobOffers;

	@Column
	@NotBlank
	String type;

	public Long getId() {
		return id;
	}

	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public String getType() {
		return type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return getType();
	}
}
