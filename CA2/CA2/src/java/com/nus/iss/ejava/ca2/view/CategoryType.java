/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author hippo
 */
@ApplicationScoped
@Named
@ManagedBean
public class CategoryType {
    private List<String> categories;
    
    @PostConstruct
    private void init(){
        categories=new ArrayList<>();
        categories.add("Social");
        categories.add("For Sale");
        categories.add("Jobs");
        categories.add("Tuition");
        categories.add("All");
    }
    
    public List<String> getAllTypes(){
        return this.categories;
    }
}
