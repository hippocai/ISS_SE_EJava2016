/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import static java.util.Locale.filter;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;

/**
 *
 * @author hippo
 */
public abstract class SocketBase {

 private static final Set<SocketBase> observers = 
          Collections.synchronizedSet(new HashSet<SocketBase>());
 
 private static final ExecutorService threadPool=Executors.newSingleThreadExecutor();
    protected SocketBase(){
        observers.add(this);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!new sockets");
    }
    
    public static void sendMessage(String msg){
        threadPool.submit(()->{
           for(SocketBase socket:observers){
               System.out.println(">>>Sending Message:"+msg);
                socket.sendMsg(msg);
            }
            System.out.println("Cleaning Begin");
            observers.removeIf((SocketBase s)->{return !s.isSessionValid();});
           
        });
   
    }
    
    protected  abstract boolean isSessionValid();
    protected abstract boolean sendMsg(String msg);
}
