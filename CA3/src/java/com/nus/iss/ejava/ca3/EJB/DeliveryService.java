/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.EJB;

import com.nus.iss.ejava.ca3.Constants.QueryString;
import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author EasonChua
 */
@Stateless
public class DeliveryService {
    @PersistenceContext(name = "CA3PU")
    private EntityManager em;
    
    public void insert(DeliveryBean deliveryBean){
        em.persist(deliveryBean);
    }
    
    public JsonArray getAllDelivery(){
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        TypedQuery<DeliveryBean> query=em.createQuery(QueryString.Delivery.FIND_ALL, DeliveryBean.class);
        List<DeliveryBean>results=query.getResultList();
        for(DeliveryBean db:results){
            arrBuilder.add(db.toJson());
        }
        return arrBuilder.build();
    }
    
    public DeliveryBean getDeliveryBeanByParams(long id){
	    return em.find(DeliveryBean.class, id);
	   // query.setParameter("note", note);
	 
	 //   return query.getSingleResult();
    }
}
