package com.training.itc.HibernateObjectStates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop 
{
	@Id
	@Column(name="lId")
	private int lId;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
    private int price;
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}
