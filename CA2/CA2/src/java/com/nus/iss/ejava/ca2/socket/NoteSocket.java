/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author hippo
 */
@RequestScoped
@ServerEndpoint("/noteSocket")
public class NoteSocket extends SocketBase {

    private Session session;


    public NoteSocket() {
       
        super();
 
         System.out.println("!!!!!!!!!!!!!!!!!!!!!NEW SOCKET");
    }

    @OnOpen
    public void open(Session session) {
        System.out.println(">>> new session: " + session.getId());
        this.session = session;
    }

    @OnClose
    public void onClose(final Session session) {

    }

    @OnMessage
    public void message(final Session session, final String msg) {
        //Do Nothing...
    }

    @Override
    protected boolean sendMsg(String msg) {
        try {
            session.getBasicRemote().sendText(msg);
            return true;
        } catch (Exception ex) {
            try {
                session.close();
            } catch (IOException e) {
            }
        }
        return false;
    }

    @Override
    protected boolean isSessionValid() {
       return session.isOpen();
    }
    
    

}
