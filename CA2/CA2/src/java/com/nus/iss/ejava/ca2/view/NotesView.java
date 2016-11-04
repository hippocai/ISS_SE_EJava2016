/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.view;

import com.nus.iss.ejava.ca2.EJB.NoteService;
import com.nus.iss.ejava.ca2.POJO.NoteBean;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hippo
 */
@SessionScoped
@Named
@ManagedBean
public class NotesView implements Serializable{
    private static final long serialVersionUID = -7745943564762744067L;
    @EJB NoteService noteService;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    private String category;
    private String content;
    public String getUserName(){
        HttpServletRequest req = 
				(HttpServletRequest)FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();
        HttpSession session=req.getSession();
       return session.getAttribute("userName").toString();
    }
    
    public String toNewPage(){
        return "NewNote?faces-redirect=true";
    }
    public String add(){
        NoteBean noteBean=new NoteBean();
        noteBean.setCategory(category);
        noteBean.setContent(content);
        noteBean.setTitle(title);
        noteService.addNote(noteBean, this.getUserName());
        return "ManageIndex?faces-redirect=true";
    }
    
    public String back(){
        return "ManageIndex?faces-redirect=true";
    }
    
    public List<NoteBean> getAllMyNotes(){
        return noteService.getNotesByUserName(this.getUserName());
    }
    
    public String logout(){
        HttpServletRequest req = 
				(HttpServletRequest)FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();
        HttpSession session=req.getSession();
        session.invalidate();
       return "ManageIndex?faces-redirect=true";
    }
}
