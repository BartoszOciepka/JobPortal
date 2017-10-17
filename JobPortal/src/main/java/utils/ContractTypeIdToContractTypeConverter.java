package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import models.ContractType;
import models.ContractTypeDao;

@Component
public class ContractTypeIdToContractTypeConverter implements Converter<Object, ContractType> {

	@Autowired
	ContractTypeDao contractTypeDao;

	@Override
	public ContractType convert(Object element) {
		Long id = Long.parseLong((String) element);
		ContractType contractType = contractTypeDao.findOne(id);
		return contractType;
	}
}
