package dto;

import mapper.anotaciones.MappingDeep;

public class Son1Dto {

	private Integer id;
	
	private String str;
	
	@MappingDeep(deep = 1)
	private ParentDto parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public ParentDto getParent() {
		return parent;
	}

	public void setParent(ParentDto parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Son1Dto [id=" + id + ", str=" + str + ", parent=" + parent + "]";
	}
}
