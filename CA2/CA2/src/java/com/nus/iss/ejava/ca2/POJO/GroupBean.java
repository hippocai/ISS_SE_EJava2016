/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.POJO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author hippo
 */
@Entity
@Table(name = "groups")
public class GroupBean implements Serializable {
    @Id
   @Column(name = "group_name")
    private String name;
    
    private String description;
    
     @ManyToMany
    @JoinTable(name="user_group",
    joinColumns = @JoinColumn(name = "group_name", 
        referencedColumnName = "group_name"), 
    inverseJoinColumns = @JoinColumn(name = "user_name", 
        referencedColumnName = "user_name"))
    private List<UserBean> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    
}
