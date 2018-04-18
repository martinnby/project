package com.gs.checkrates.mas.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties({ "help" })
public class Response{


	public Response() {
		super();
	}

	public Response(String success, Result result) {
		super();
		this.success = success;
		this.result = result;
	}


	@JsonProperty("success")
	String success;
	
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}


	@JsonProperty("result")
	Result result;
	
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Response [success=" + success + ", result=" + result + ", getSuccess()=" + getSuccess()
				+ ", getResult()=" + getResult() + "]";
	}
}
