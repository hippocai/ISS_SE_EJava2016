/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.rest;

import com.nus.iss.ejava.ca2.EJB.NoteService;
import com.nus.iss.ejava.ca2.task.GetAllNotesTask;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author hippo
 */
@RequestScoped
@Path("notes")
public class NoteResource {
    @Resource
    private ManagedExecutorService executors;
    @EJB NoteService noteService;
    
    @GET
    public void getAllNotes(@Suspended AsyncResponse asyncResponse){
        executors.execute(new GetAllNotesTask(asyncResponse, noteService));
    }
}
