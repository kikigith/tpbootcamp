package com.bootcamp.tp.models.dependencies;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


@MappedSuperclass
public class BaseEntite implements Serializable,Comparable	{
	
	private final static long serialVersionUID=Long.MIN_VALUE;
	
	@Version	
	private Long version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	
	
	
	public Long getVersion() {
		return version;
	}




	public void setVersion(Long version) {
		this.version = version;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




//	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		BaseEntite other=(BaseEntite) obj;
		if(equals(other)){
		   return 0;
		}
		return getId().compareTo(other.getId());
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if ((obj == null)||(!(obj instanceof BaseEntite)))
			return false;
		
		BaseEntite otherObject= (BaseEntite) obj;
		if (getClass() != obj.getClass())
			return false;
		BaseEntite other = (BaseEntite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	
	
	
 
	
}
