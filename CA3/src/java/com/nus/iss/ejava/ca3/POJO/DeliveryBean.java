/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.POJO;

import java.math.BigDecimal;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EasonChua
 */
@Entity
@Table(name="delivery")

public class DeliveryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pkg_id")
    private long pkgId;
    
    private String name;
    
    private String address;
    
    private String phone;
    
    @Column(name="create_date")
      @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(mappedBy="delivery")
    private PodBean podBean;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public PodBean getPodBean() {
        return podBean;
    }

    public void setPodBean(PodBean podBean) {
        this.podBean = podBean;
    }
    
    public long getPkgId() {
        return pkgId;
    }

    public void setPkgId(long pkgId) {
        this.pkgId = pkgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("phone", phone)
                .add("name", name)
                .add("id", pkgId)
                .add("podId", pkgId)
                .add("address", address)
                .add("date", createDate.getTime())
                .add("teamId", "e1259f57")
                .build());
    }
  
    
    
    
}
