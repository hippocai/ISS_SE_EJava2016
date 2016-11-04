/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.view;

import com.nus.iss.ejava.ca2.EJB.RegisterService;
import com.nus.iss.ejava.ca2.POJO.UserBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author hippo
 */
@RequestScoped
@ManagedBean
@Named
public class RegisterView {
    private String username;
    private String password;
    private String repassword;

    @EJB RegisterService registerService;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    public String register(){
        if(username==null||username.equals("")){
            FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("User Name Can Not Be Empty"));
            return null;
        }
        if(registerService.isUserNameExisted(username)){
            FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("User Already Existed"));
            return null;
        }
        if(!password.equals(repassword)){
            FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("2 password not same"));
            return null;
        }
        
        if(password==null||password.length()<6){
                FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Password size should more than 6"));
                return null;
        }
        UserBean userBean=new UserBean();
        userBean.setName(username);
        userBean.setPassword(password);
        registerService.addUser(userBean);
        return "Login";
    }
    
    public String back(){
        return "Login";
    }
    
}
