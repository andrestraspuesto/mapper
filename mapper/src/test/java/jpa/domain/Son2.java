package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class Son2 extends Domain implements Comparable<Son2>{

	
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

	@Override
	public int compareTo(Son2 o) {
		if(id == null){
			return -1;
		}
		if(o == null || o.getId() == null){
			return 1;
		}
		int cmp = id - o.getId();
		return cmp;
		
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	
}
