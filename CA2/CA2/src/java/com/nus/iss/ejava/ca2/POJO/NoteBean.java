/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hippo
 */
@Entity
@Table(name = "note")
public class NoteBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "date_time")
    private Long dateTime;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private String category;
    
    private String content;
    @ManyToOne
      @JoinColumn(name ="user_name",referencedColumnName="user_name")
    UserBean user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }
    
    public String getDateString(){
        Date date=new Date(this.dateTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");      	
	return format.format(date);
    }
    
    public JsonObject toJson(){
           return (Json.createObjectBuilder()
                   .add("id", id+"")
                   .add("title", title)
                   .add("dateTime", this.getDateString())
                   .add("user", this.user.getName())
                   .add("category", category)
                   .add("content", content)
                   .build());
    }
}
