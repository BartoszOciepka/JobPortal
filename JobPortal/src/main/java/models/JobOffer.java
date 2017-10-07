package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;

@Entity
public class JobOffer {
	
	@Id
	@GeneratedValue
	Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@NotBlank
	@Column
	String name;
	@NotBlank
	@Column
	String description;
	@NotBlank
	@Column
	String city;
	public List<Qualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="job_qual",
			joinColumns= {@JoinColumn(name="joboffer", 
			referencedColumnName="id") },
			
			inverseJoinColumns= { @JoinColumn(name="qualification",
			referencedColumnName="id")
			})
	private List<Qualification> qualifications;
	
	
	public String toString() {
		return name + " " + city;
	}
}
