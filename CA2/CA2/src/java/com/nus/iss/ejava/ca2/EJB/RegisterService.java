/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.EJB;

import com.nus.iss.ejava.ca2.Constants.Configure;
import com.nus.iss.ejava.ca2.POJO.UserBean;
import com.nus.iss.ejava.ca2.POJO.GroupBean;
import com.nus.iss.ejava.ca2.util.SHA256;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hippo
 */
@Stateless
public class RegisterService {
    @PersistenceContext(name = "CA2PU")
    private EntityManager em;
    
    public boolean isUserNameExisted(String userName){
        UserBean userBean=em.find(UserBean.class, userName);
        if(userBean!=null){
            return true;
        }
        return false;
    }
    public void addUser(UserBean user){
        user.setPassword(SHA256.Encode(user.getPassword()));
        em.persist(user);
        GroupBean groupBean=em.find(GroupBean.class, Configure.MANAGE_GROUP);
        groupBean.getUsers().add(user);
    }
}
