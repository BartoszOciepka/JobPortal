package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import models.Qualification;
import models.QualificationDao;

@Component
public class QualificationIdToQualificationConverter implements Converter<Object, Qualification>{
	@Autowired
	QualificationDao qualificationDao;
	
	@Override
	public Qualification convert(Object element) {
		Long id = Long.parseLong((String)element);
		Qualification qualification = qualificationDao.findOne(id);
		return qualification;
	}
}
