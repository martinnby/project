package com.gs.checkrates.util.rest.mas;


import static org.junit.Assert.*;

import javax.ws.rs.ProcessingException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gs.checkrates.mas.model.*;
import com.gs.checkrates.util.rest.mas.RestAdaptor;

public class RestAdaptorOnlineTest {


    public static boolean  RECORD_RETRIEVED = true;


    
    @Test
    public void givenCorrectData_WebAPiCall_thenSuccess() {
        RestAdaptor client = RestAdaptor.getInstance();
    	Request req = new Request();
    	req.setResourceId("5f2b18a8-0883-4769-a635-879c63d3caac");
        Response response = client.get(req);

        assertEquals(response.getSuccess(), String.valueOf(RECORD_RETRIEVED));
    }

}
