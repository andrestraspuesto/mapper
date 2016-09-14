package mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.Config;
import daos.ParentDao;
import dto.ParentDto;
import dto.Son1Dto;
import jpa.domain.Parent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)

public class MapperImplJPATest  extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	ParentDao parentDao;
	
	
	@Test
	public void domainToDto(){
		Parent parent = parentDao.getById(1);
		MapperInterface mapper = MapperFactory.getInstance(Locale.GERMAN);
		ParentDto dto = mapper.map(ParentDto.class, parent);
		System.out.println(dto);
		int counter = 1;
		for(Son1Dto son1: dto.getListaSon1()){
			assertEquals("son1 "+ counter++, son1.getStr());
		}
	}
	
	@Test
	public void DtoToDomain(){
		ParentDto dto = new ParentDto();
		
		List<Son1Dto> listaSon1 = new ArrayList<>();
		Son1Dto s1 = new Son1Dto();
		
		s1.setStr("s1");
		s1.setParent(dto);
		Son1Dto s1_2 = new Son1Dto();
		
		s1_2.setStr("s1_2");
		s1_2.setParent(dto);
		listaSon1.add(s1_2);
		dto.setListaSon1(listaSon1);
		Parent parent = MapperFactory.getInstance(Locale.GERMAN).map(Parent.class, dto);
		assertNull(parent.getSetSon2());
		parentDao.save(parent);
		assertNotNull(parent.getId());
		assertEquals(dto.getListaSon1().size(), parent.getListaSon1().size());
		System.out.println(parent);
		
	}

}
