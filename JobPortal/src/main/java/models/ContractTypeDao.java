package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContractTypeDao extends CrudRepository<ContractType, Long>{
	List<ContractType> findAll();
	List<ContractType >findByTypeIgnoreCase(String type);
}
