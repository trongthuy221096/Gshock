package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Category;

import model.bean.Oderitem;
import model.bean.User;
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.OderitemDAO;
import model.dao.WatchDAO;
import util.FileUtil;

@MultipartConfig
public class PublicRemoveOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderitemDAO oderitemDAO;
	private WatchDAO watchDAO = new WatchDAO();
	private ArrayList<Oderitem> listOderitem = new ArrayList<>(); 
    public PublicRemoveOderitemController() {
        super();
        oderitemDAO = new OderitemDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int wid = 0;
		try {
			wid =Integer.parseInt(request.getParameter("wid"));
		} catch (Exception e) {		
		}
		Watch watch = watchDAO.getItemByID(wid);
		ArrayList<Oderitem> listOderitem = (ArrayList<Oderitem>)session.getAttribute("listOderitem");
		System.out.println(listOderitem.size());
		if(listOderitem!=null && listOderitem.size()>0) {
			int i = 0;
			for(Oderitem oderitem:listOderitem) {			
				if(oderitem.getWid()==wid) {						
					oderitem.setQualiti(oderitem.getQualiti()-1);
					if(oderitem.getQualiti()==0) {
						listOderitem.remove(i);
					}
					RequestDispatcher rd = request.getRequestDispatcher("/pay");
					rd.forward(request, response);
					return;
				}
				i++;
			}
		
		}		
		RequestDispatcher rd = request.getRequestDispatcher("/pay");
		rd.forward(request, response);	
		
		}


}
