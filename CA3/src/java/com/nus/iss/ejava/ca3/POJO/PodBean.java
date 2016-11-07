/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.POJO;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EasonChua
 */
@Entity
@Table(name="pod")
public class PodBean implements Serializable{
    @Id
    @Column(name="pod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long podId;
    
    private String note;
    
    private byte[] image;
    
      @Column(name="delivery_date")
      @Temporal(TemporalType.TIMESTAMP)
      private Date deliveryDate;
      
      @Column(name="ack_id")
      private String ackId;

      @OneToOne
      @JoinColumn(name ="pkg_id",referencedColumnName="pkg_id")
      private DeliveryBean delivery;

    public DeliveryBean getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryBean delivery) {
        this.delivery = delivery;
    }
      
    public long getPodId() {
        return podId;
    }

    public void setPodId(long podId) {
        this.podId = podId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

   

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAckId() {
        return ackId;
    }

    public void setAckId(String ackId) {
        this.ackId = ackId;
    }
      
      
      
}
