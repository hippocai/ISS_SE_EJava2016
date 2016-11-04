/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hippo
 */

@ViewScoped
@ManagedBean
@Named
public class LoginView implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

        public String register(){
            return "Register";
        }
	public String login() {
		HttpServletRequest req = 
				(HttpServletRequest)FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();
                HttpSession session=req.getSession();
                if(req.isRequestedSessionIdValid()&&session.getAttribute("userName")!=null&&!session.getAttribute("userName").equals("")){
                    return ("manage/ManageIndex?faces-redirect=true");
                }
		try {
			req.login(username, password);
                        
		} catch (Throwable t) {
                    t.printStackTrace();
                   // System.out.println("com.nus.iss.ejava.ca2.view.LoginView.login()");
			FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Incorrect login"));
			return (null);
		}
          
          session.setAttribute("userName", username);
		return ("manage/ManageIndex?faces-redirect=true");
	}

}