/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.rest;

import com.nus.iss.ejava.ca3.EJB.PodService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Snow
 */
@RequestScoped
@Path("/callback")
public class CallbackRest {
	@EJB PodService ps;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response callback(@QueryParam("podId")String podId,@QueryParam("ackId")String ackId){
		ps.update(podId, ackId);
		 System.out.print("CALLBACK!!!!!!!!!");
		return Response.status(Response.Status.OK).build();
	}
}
