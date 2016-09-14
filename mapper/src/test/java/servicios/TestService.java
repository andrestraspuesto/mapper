package servicios;
import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import daos.ParentDao;
import dto.ParentDto;
import jpa.domain.Parent;
import mapper.MapperFactory;
import mapper.MapperInterface;

@org.springframework.stereotype.Service

@Transactional(propagation=Propagation.REQUIRED)
public class TestService {
	@Autowired
	private ParentDao parentDao;
	
	
	public ParentDto getDto(Integer id){
		Parent parent = parentDao.getById(1);
		MapperInterface mapper = MapperFactory.getInstance(Locale.GERMAN);
		return mapper.map(ParentDto.class, parent);
		
	}

}
