package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;
import util.StringUtil;

/**
 * Servlet implementation class GetListController
 */
@WebServlet("/GetListController")
public class GetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetListController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		CatDAO catDAO = new CatDAO();
		//ArrayList<Category> listCat = catDAO.getItems();
		//parent(listCat,request,response);
		
	}
	public void parent(ArrayList<Category> listCat, HttpServletRequest request, HttpServletResponse response){		
		for(Category cat:listCat) {
			if(cat.getParent()==0) {								
				try {					
					response.getWriter().print("<li><a class=\"dropdown-item\" href=\""+request.getContextPath()+"/"+StringUtil.makeSlug(cat.getName())+"-"+cat.getId()+"\">"+cat.getName()+"</a></li>");
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
				try {//+"\">"+"-".repeat(cat.getLever())
					response.getWriter().print("<li><a class=\"dropdown-item\" href=\""+request.getContextPath()+"/"+StringUtil.makeSlug(cat.getName())+"-"+cat.getId()+" "+cat.getName()+"</a></li>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				getchild(listCat, cat.getId(),request,response);		
			}		
		}
		
	}
}
