package models;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationDao extends CrudRepository<Qualification, Long>{
	List<Qualification> findAll();
	List<Qualification> findByName(String name);
}
