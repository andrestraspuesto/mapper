package jpa.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import mapper.anotaciones.MappingDeep;

@Entity
@SequenceGenerator(name="guidSequence",sequenceName="guid_seq" )
public class Parent extends Domain{
	
	

	@MappingDeep(deep = 1)
	@OneToMany(mappedBy="parent",fetch = FetchType.LAZY )
	private List<Son1> listaSon1;
	
	@MappingDeep(deep = 1)
	@OneToMany(mappedBy="parent",fetch = FetchType.LAZY)
	private Set<Son2> setSon2;

	
	public List<Son1> getListaSon1() {
		return listaSon1;
	}

	public void setListaSon1(List<Son1> listaSon1) {
		this.listaSon1 = listaSon1;
	}

	public Set<Son2> getSetSon2() {
		return setSon2;
	}

	public void setSetSon2(Set<Son2> setSon2) {
		this.setSon2 = setSon2;
	}

	
	
}
