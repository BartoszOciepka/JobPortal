package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyDao extends CrudRepository<Company, Long>{
	List<Company> findAll();
}
