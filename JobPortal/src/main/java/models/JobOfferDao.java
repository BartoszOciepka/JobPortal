package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobOfferDao extends CrudRepository<JobOffer, Long>{
	List<JobOffer> findAll();
}
