package com.ashokit.entity;

import jakarta.persistence.ManyToOne;

public class Address {
	
	Integer id;
	String stateName;
	String cityName;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", stateName=" + stateName + ", cityName=" + cityName + "]";
	}
	
	
	

}
