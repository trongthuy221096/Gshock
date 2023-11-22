package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.bean.Category;
import model.bean.Oderitem;
import model.dao.CatDAO;
import model.dao.OderitemDAO;

public class PublicDellOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderitemDAO oderitemDAO;   

    public PublicDellOderitemController() {
        super();
        oderitemDAO = new OderitemDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wid = 0;
		try {
			wid = Integer.parseInt(request.getParameter("wid"));		
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/pay");
			return;
		}

		HttpSession session = request.getSession();
		ArrayList<Oderitem> listOderitem = (ArrayList<Oderitem>)session.getAttribute("listOderitem");
		System.out.println(listOderitem.size());
		if(listOderitem!=null && listOderitem.size()>0) {
			int i = 0;
			for(Oderitem oderitem:listOderitem) {			
				if(oderitem.getWid()==wid) {						
					listOderitem.remove(i);
					RequestDispatcher rd = request.getRequestDispatcher("/pay");
					rd.forward(request, response);
					return;
				}
				i++;
			}
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("/pay");
		rd.forward(request, response);
		return;
	}

}
