package com.gs.checkrates.mas.service;

import java.util.List;

import com.gs.checkrates.mas.model.*;
import com.gs.checkrates.util.rest.mas.*;

public class MASManager {
	
    public Response checkMonthlyRates(String input ) {
    	RestAdaptor masClient = RestAdaptor.getInstance();
    	Request req = new Request();
    	req.setResourceId("5f2b18a8-0883-4769-a635-879c63d3caac");
    	req.setMonthYear(input);
    	req.setSort("end_of_month asc");
    	return masClient.get(req); 
    }
    
//    //For others API
//    public Response checkYearlyRates(String input ) {
//    	RestAdaptor masClient = RestAdaptor.getInstance();
//    	Request req = new Request();
//    	req.setResourceId("bd841397-108f-4644-8da3-38a7c159d68a");
//    	req.setMonthYear(input);
//    	req.setSort("year asc");
//    	return masClient.get(req); 
//    }
    
    

}
