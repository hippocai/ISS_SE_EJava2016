/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.EJB;

import com.nus.iss.ejava.ca2.Constants.QueryString;
import com.nus.iss.ejava.ca2.POJO.NoteBean;
import com.nus.iss.ejava.ca2.POJO.UserBean;
import com.nus.iss.ejava.ca2.socket.SocketBase;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author hippo
 */
@Stateless
public class NoteService {
    @PersistenceContext(name = "CA2PU")
    private EntityManager em;
    
    public void addNote(NoteBean noteBean,String userName){
        noteBean.setDateTime(new Date().getTime());
        UserBean userBean=em.find(UserBean.class, userName);
        noteBean.setUser(userBean);
        em.persist(noteBean);
        SocketBase.sendMessage(noteBean.toJson().toString());
    }
    
    public List<NoteBean> getNotesByUserName(String userName){
        TypedQuery<NoteBean> query=em.createQuery(QueryString.Note.FIND_NOTES_BY_USER,NoteBean.class);
        query.setParameter("name", userName);
        return query.getResultList();
    }
    
    public List<NoteBean> getAllNotes(){
        TypedQuery<NoteBean> query=em.createQuery(QueryString.Note.FIND_ALL_NOTES,NoteBean.class);
        return query.getResultList();
    }
    
}
