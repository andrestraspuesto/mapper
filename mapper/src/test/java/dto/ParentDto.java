package dto;

import java.util.List;
import java.util.Set;

public class ParentDto {

	private Integer id;

	
	private List<Son1Dto> listaSon1;
	
	
	private Set<Son2Dto> setSon2;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Son1Dto> getListaSon1() {
		return listaSon1;
	}


	public void setListaSon1(List<Son1Dto> listaSon1) {
		this.listaSon1 = listaSon1;
	}


	public Set<Son2Dto> getSetSon2() {
		return setSon2;
	}


	public void setSetSon2(Set<Son2Dto> setSon2) {
		this.setSon2 = setSon2;
	}


	@Override
	public String toString() {
		return "ParentDto [id=" + id + ", listaSon1=" + listaSon1 + ", setSon2=" + setSon2 + "]";
	}
}
