package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public test() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> listCat = new ArrayList<>();
		CatDAO catDAO = new CatDAO();
		listCat= catDAO.getItems();
		for(Category cat:listCat) {
			dmDaCap(cat.getName(), cat.getParent(),cat.getId());
		
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	
	public static void dmDaCap(String name, int parent,int id) {
		//id_dm, tendm, parent_id =0, 1, 2
		int lever=0;
		
		if(parent==lever) {
			System.out.println(name);			
		}
		System.out.println(lever);
		lever++;
		if(parent<lever) {			
		dmDaCap(name, parent,id);		
		}else {
			return;
		}
	}
	public static void Menucon(String name, int parent,int id) {
		//id_dm, tendm, parent_id =0, 1, 2			
	
		if(parent>id) {			
		dmDaCap(name, parent,id);
		}
	}

}
