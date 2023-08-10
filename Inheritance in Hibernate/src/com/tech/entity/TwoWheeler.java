package com.tech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TwoWheeler extends Vehicle {
	
	private String Colour;

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	

}
