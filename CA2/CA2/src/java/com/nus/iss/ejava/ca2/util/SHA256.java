/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca2.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	 public static String Encode(final String strText)  
	  {  
		 String strType="SHA-256";
	   
	    String strResult = null;  
	  
	   
	    if (strText != null && strText.length() > 0)  
	    {  
	      try  
	      {  
	       
	        MessageDigest messageDigest = MessageDigest.getInstance(strType);  
	       
	        messageDigest.update(strText.getBytes());  
	         
	        byte byteBuffer[] = messageDigest.digest();  
	  
	        
	        StringBuffer strHexString = new StringBuffer();  
	        
	        for (int i = 0; i < byteBuffer.length; i++)  
	        {  
	          String hex = Integer.toHexString(0xff & byteBuffer[i]);  
	          if (hex.length() == 1)  
	          {  
	            strHexString.append('0');  
	          }  
	          strHexString.append(hex);  
	        }  
	        
	        strResult = strHexString.toString();  
	      }  
	      catch (NoSuchAlgorithmException e)  
	      {  
	        e.printStackTrace();  
	      }  
	    }  
	  
	    return strResult;  
	  }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SHA256.Encode("123456"));
	}

}
