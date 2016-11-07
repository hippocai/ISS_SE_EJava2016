/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.task;

import com.nus.iss.ejava.ca3.EJB.DeliveryService;
import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import javax.json.JsonArray;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author EasonChua
 */
public class DeliveryTask {
    public static final class CreateDelivery implements Runnable{
        private final DeliveryService ds;
        private final AsyncResponse async;
        private final DeliveryBean db;
        
        public CreateDelivery(AsyncResponse async,DeliveryService ds,DeliveryBean db){
            this.async=async;
            this.ds=ds;
            this.db=db;
        }
        @Override
        public void run() {
            ds.insert(db);
            async.resume(Response.ok().entity("Success").build());
        }
        
    }
    
    public static final class GetAllDelivery implements Runnable{
           private final DeliveryService ds;
        private final AsyncResponse async;
        private final JsonArray jarr;
        public GetAllDelivery(AsyncResponse async,DeliveryService ds,JsonArray ja){
            this.ds=ds;
            this.async=async;
            this.jarr=ja;
        }
        @Override
        public void run() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        async.resume(Response.ok().entity(jarr).build());
        }
        
    }
}
