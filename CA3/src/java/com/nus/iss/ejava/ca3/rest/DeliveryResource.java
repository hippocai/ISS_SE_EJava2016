/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.rest;

import com.nus.iss.ejava.ca3.EJB.DeliveryService;
import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import com.nus.iss.ejava.ca3.task.DeliveryTask;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author EasonChua
 */
@RequestScoped
@Path("delivery")
public class DeliveryResource {
     @Resource
    private ManagedExecutorService executors;
     @EJB DeliveryService ds;
     
     @GET
     public void getAllDatas(@Suspended AsyncResponse asyncResponse){
         executors.execute(new DeliveryTask.GetAllDelivery(asyncResponse, ds, ds.getAllDelivery()));
         
     } 
     @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createDelivery(MultivaluedMap<String, String> form,@Suspended AsyncResponse asyncResponse){
        String name=form.getFirst("name");
        String address=form.getFirst("address");
        String phone=form.getFirst("phone");
        Date date=new Date();
        DeliveryBean db=new DeliveryBean();
        db.setAddress(address);
        db.setCreateDate(date);
        db.setName(name);
        db.setPhone(phone);
        executors.submit(new DeliveryTask.CreateDelivery(asyncResponse,ds,db));
        
    }
}
