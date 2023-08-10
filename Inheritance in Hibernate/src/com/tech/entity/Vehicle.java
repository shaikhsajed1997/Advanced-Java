package com.tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int v_Id;
	
	private String v_Name;
	
	private double v_Price;

	public int getV_Id() {
		return v_Id;
	}

	public void setV_Id(int v_Id) {
		this.v_Id = v_Id;
	}

	public String getV_Name() {
		return v_Name;
	}

	public void setV_Name(String v_Name) {
		this.v_Name = v_Name;
	}

	public double getV_Price() {
		return v_Price;
	}

	public void setV_Price(double v_Price) {
		this.v_Price = v_Price;
	}
	
}
