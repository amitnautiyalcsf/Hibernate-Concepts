package org.o7planning.DemoHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="alien_table_Embedable")
public class Alien // pojo class 
{

	@Id
	private int aid;
	
	// @Transient use to store the temporary data.
	private AlienName aname;
	
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	@Column(name="alien_color")
	private String color;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	
	
	
}
