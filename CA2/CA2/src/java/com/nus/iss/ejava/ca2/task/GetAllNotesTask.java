/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.task;

import com.nus.iss.ejava.ca2.EJB.NoteService;
import com.nus.iss.ejava.ca2.POJO.NoteBean;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author hippo
 */
public class GetAllNotesTask implements Runnable{

    private final AsyncResponse async;
    private final NoteService noteService;
    public GetAllNotesTask(AsyncResponse response,NoteService noteService){
        this.async=response;
        this.noteService=noteService;
    }
    @Override
    public void run() {
         JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
         List<NoteBean> notes=noteService.getAllNotes();
         for(NoteBean note:notes){
             arrBuilder.add(note.toJson());
         }
         async.resume(Response.ok().entity(arrBuilder.build()).build());
    }
    
}
