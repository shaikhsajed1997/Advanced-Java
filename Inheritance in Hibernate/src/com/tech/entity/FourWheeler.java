package com.tech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FourWheeler extends Vehicle{
	
	private String Colour;

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

}
