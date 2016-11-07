/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.EJB;

/**
 *
 * @author EasonChua
 */
 
import com.nus.iss.ejava.ca3.Constants.QueryString;
import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import com.nus.iss.ejava.ca3.POJO.PodBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PodService {
    @PersistenceContext(name = "CA3PU")
    private EntityManager em;
    
    public long insert(PodBean podBean){
        em.persist(podBean);
        return podBean.getPodId();
    }
    
    public void update(PodBean podBean){
	    em.merge(podBean);
    }
    public long getPodIdByPkgId(long pkgId){
	    TypedQuery<PodBean> query=em.createQuery(QueryString.Pod.GET_PODID_BY_PKG_ID, PodBean.class);
	    query.setParameter("pkgId", pkgId);
	    return query.getSingleResult().getPodId();
	    
    }
    
    public void update(String podId,String acId){
	   PodBean podBean= em.find(PodBean.class, Long.parseLong(podId));
	   podBean.setAckId(acId);
	   em.merge(podBean);
	    
    }
    
}
