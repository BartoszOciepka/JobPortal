package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class JobOffer {
	
	@Column
	String aboutUs;
	@NotBlank
	@Column
	String city;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COMPANY_ID")
	Company company;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CONTRACTTYPE_ID")
	private ContractType contractType;
	@NotBlank
	@Column
	String description;
	@Column
	Integer experience;
	@Id
	@GeneratedValue
	Long id;
	@Column
	Boolean isSponsored;
	
	@Column
	Double maxSalary;
	
	@Column
	Integer maxWorkingHours;
	
	@Column
	Double minSalary;
	
	@Column
	Integer minWorkingHours;

	@NotBlank
	@Column
	String name;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name="job_qual",
			joinColumns= {@JoinColumn(name="joboffer", 
			referencedColumnName="id") },
			
			inverseJoinColumns= { @JoinColumn(name="qualification",
			referencedColumnName="id")
			})
	private List<Qualification> qualifications;
	@Column
	@Min(0)
	Integer vacancies;
	public String getAboutUs() {
		return aboutUs;
	}
	public String getCity() {
		return city;
	}
	public Company getCompany() {
		return company;
	}
	public ContractType getContractType() {
		return contractType;
	}
	public String getDescription() {
		return description;
	}
	public Integer getExperience() {
		return experience;
	}
	public Long getId() {
		return id;
	}
	public Boolean getIsSponsored() {
		return isSponsored;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public Integer getMaxWorkingHours() {
		return maxWorkingHours;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public Integer getMinWorkingHours() {
		return minWorkingHours;
	}
	public String getName() {
		return name;
	}
	public List<Qualification> getQualifications() {
		return qualifications;
	}
	public Integer getVacancies() {
		return vacancies;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCompany(Company company) {
		this.company = company;
		if(!company.getJobOffers().contains(this))
			company.getJobOffers().add(this);
	}
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
		if(!contractType.getJobOffers().contains(this)) {
			contractType.getJobOffers().add(this);
		}
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIsSponsored(Boolean isSponsored) {
		this.isSponsored = isSponsored;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public void setMaxWorkingHours(Integer maxWorkingHours) {
		this.maxWorkingHours = maxWorkingHours;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public void setMinWorkingHours(Integer minWorkingHours) {
		this.minWorkingHours = minWorkingHours;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}
	public String toString() {
		return name + " " + city;
	}
}
