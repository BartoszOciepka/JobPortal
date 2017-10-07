package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QualificationDao extends CrudRepository<Qualification, Long>{

	List<Qualification> findAll();
}
