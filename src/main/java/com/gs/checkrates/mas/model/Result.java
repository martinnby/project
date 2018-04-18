package com.gs.checkrates.mas.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "fields","total","offset","resource_id"})	
	public class Result{
		


	public Result() {
			super();
		}

	public Result(String limit, List<MonthlyRates> records) {
			this.limit = limit;
			this.records = records;
		}

	@JsonProperty("limit")
	String limit;	

	@JsonProperty("records")
	List<MonthlyRates> records;
	//TO-DO -  this should be a Map or generic collection to store different type of records for MAS API

public List<MonthlyRates> getRecords() {
		return records;
	}

	public void setRecords(List<MonthlyRates> records) {
		this.records = records;
	}

public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "Result [limit=" + limit + ", records=" + records + "]";
	}

	



}
