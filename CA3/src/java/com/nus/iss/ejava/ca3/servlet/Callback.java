/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.servlet;

import com.nus.iss.ejava.ca3.EJB.PodService;
import com.sun.mail.iap.Response;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Snow
 */
@WebServlet("/callback")

public class Callback extends HttpServlet{

	@EJB PodService ps;
	 @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
	    System.out.print("CALLBACK!!!!!!!!!");
	    String podId=request.getParameter("podId");
	    String ack=request.getParameter("ackId");
	    ps.update(podId, ack);
	    response.setStatus(Response.OK);
	    
    }
	
}
