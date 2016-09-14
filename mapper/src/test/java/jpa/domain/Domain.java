package jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass

public abstract class Domain {

	@Id
	@SequenceGenerator(name="guidSequence",sequenceName="guid_seq" )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="guidSequence")
	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
