package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import mapper.anotaciones.MappingDeep;

@Entity

public class Son1 extends Domain{
	
	private String str;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_parent")
	private Parent parent;
	
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	

}
