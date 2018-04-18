package com.gs.checkrates.mas.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Request{


	public Request() {
		super();
	}
	
	String monthYear;
	
	int limit=12;
	
	String sort;
	
	String resourceId;
	
	public String getMonthYear() {
		return monthYear;
	}
	
	public String getMonthYearFormatted() {
		
		
		return monthYear.replaceAll(" to ", ",");
	}
	
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
