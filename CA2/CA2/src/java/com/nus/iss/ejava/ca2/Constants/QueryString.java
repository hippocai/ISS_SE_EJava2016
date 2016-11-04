/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.Constants;

/**
 *
 * @author hippo
 */
public class QueryString {
    public static final class Group{
        public static final String FINDGROUPBYNAME_STRING="select g from GroupBean g where g.name = :name";
    }
    
    public static final class User{
        public static final String FIND_USER_BY_NAME_STRING="select u from UserBean u where u.name=:name";
    }
    
    public static final class Note{
        public static final String FIND_NOTES_BY_USER="select n from NoteBean n where n.user.name=:name";
        
        public static final String FIND_ALL_NOTES="select n from NoteBean n ORDER BY n.dateTime DESC";
    }
    
}
