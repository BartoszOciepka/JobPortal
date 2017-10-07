package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class JobOffer {
	
	@NotBlank
	@Column
	String city;
	@NotBlank
	@Column
	String description;
	@Id
	@GeneratedValue
	Long id;
	@NotBlank
	@Column
	String name;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="job_qual",
			joinColumns= {@JoinColumn(name="joboffer", 
			referencedColumnName="id") },
			
			inverseJoinColumns= { @JoinColumn(name="qualification",
			referencedColumnName="id")
			})
	private List<Qualification> qualifications;
	public String getCity() {
		return city;
	}
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Qualification> getQualifications() {
		return qualifications;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	
	public String toString() {
		return name + " " + city;
	}
}
