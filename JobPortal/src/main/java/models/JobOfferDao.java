package models;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferDao extends CrudRepository<JobOffer, Long>{
	List<JobOffer> findAll();
	List<JobOffer> findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(String phrase, String city);
}
