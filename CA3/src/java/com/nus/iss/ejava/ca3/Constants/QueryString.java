/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.Constants;

/**
 *
 * @author EasonChua
 */
public class QueryString {
    public static final class Delivery{
        public static final String FIND_ALL="select d from DeliveryBean d";
	public static final String FIND_ByP="select d from DeliveryBean d where p.note=:note";
    }
    
    public static final class Pod{
        public static final String GET_PODID_BY_PKG_ID="select p from PodBean p where p.delivery.pkgId=:pkgId";
    }
}
