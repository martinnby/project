package com.gs.checkrates.util.rest.mas;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.gs.checkrates.mas.model.*;

public class RestAdaptor {

	private static final String REST_URI = "https://eservices.mas.gov.sg/api/action/datastore/search.json";
    
	private Client client = ClientBuilder.newClient();

	 private static final RestAdaptor instance = new RestAdaptor();
	    
	    //private constructor to avoid client applications to use constructor
	    private RestAdaptor(){}

	    public static RestAdaptor getInstance(){
	        return instance;
	    }
	    
	public Response get(Request req) {
        return buildQueryParam(client.target(REST_URI),req)
        		.request(MediaType.APPLICATION_JSON)
        		.get(Response.class);
        
    }
	
	public WebTarget buildQueryParam(WebTarget target, Request req){
		//the intention here is to have a dynamics query builder
		return  target.queryParam("resource_id", req.getResourceId())
			  //  .queryParam("limit", Integer.valueOf(req.getLimit()))
			    .queryParam("between[end_of_month]",req.getMonthYearFormatted())
			    .queryParam("sort", "end_of_month asc");
	}
	//update
	//create
	//delete
 
}
