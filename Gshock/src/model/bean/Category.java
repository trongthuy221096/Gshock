package model.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import util.StringUtil;

public class Category {                                                                 
	private int id;                                                                     
	private String name;                                                                
	private int parent;                                                                 
	private String picture; 
	private int lever;
	 
	public int getId() {                                                                
	return id;                                                                      
	}                                                                                   
	public void setId(int id) {                                                         
	this.id = id;                                                                   
	}                                                                                   
	public String getName() {                                                           
	return name;                                                                    
	}                                                                                   
	public void setName(String name) {                                                  
	this.name = name;                                                               
	}                                                                                   
	public int getParent() {                                                            
	return parent;                                                                  
	}                                                                                   
	public void setParent(int parent) {                                                 
	this.parent = parent;                                                           
	}	                                                                                
	public String getPicture() {                                                        
	return picture;                                                                 
	}                                                                                   
	public void setPicture(String picture) {                                            
	this.picture = picture;                                                         
	}                                                                                   	    
	public int getLever() {
		return lever;
	}
	public void setLever(int lever) {
		this.lever = lever;
	}
	
	public Category(int id, String name, int parent, String picture) {                  
	super();                                                                        
	this.id = id;                                                                   
	this.name = name;                                                               
	this.parent = parent;                                                           
	this.picture = picture;                                                         
	}                                                                                   
	    
	    
	public Category(int id, String name, int parent, String picture, int lever) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.picture = picture;
		this.lever = lever;
	}
	public Category() {                                                                 
	super();                                                                        
	}
//	public String parent(Category cat,ArrayList<Category> listCat){		
//        String parent = "";																	
//		parent="<option value=\""+cat.getId()+"\">"+cat.getName()+"</option>";
//		getchild(cat, cat.getId());
//        return parent;
//		
//	}


	public void parent(ArrayList<Category> listCat, HttpServletRequest request, HttpServletResponse response){		
		for(Category cat:listCat) {
			if(cat.getParent()==0) {								
				try {					
					response.getWriter().print("<option value=\""+cat.getId()+"\">"+cat.getName()+"</option>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				getchild(listCat, cat.getId(),request,response);
			}
			
		}
	}
	public void getchild(ArrayList<Category> listCat , int id ,HttpServletRequest request, HttpServletResponse response){
		for(Category cat:listCat) {
			if(cat.getParent()==id) {
				try {
					response.getWriter().print("<option value=\""+cat.getId()+"\">"+"-" );//.repeat(cat.getLever())+cat.getName()+"</option>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				getchild(listCat, cat.getId(),request,response);		
			}		
		}
		
	}
}