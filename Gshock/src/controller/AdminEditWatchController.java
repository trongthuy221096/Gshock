package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.WatchDAO;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminEditWatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WatchDAO watchDAO;
	private CatDAO catDAO;
    public AdminEditWatchController() {
        super();
        watchDAO = new WatchDAO();
        catDAO = new CatDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int id=0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		ArrayList<Category> listCat = catDAO.getItems();
		Watch watch = watchDAO.getItemByID(id);
		request.setAttribute("watch", watch);
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int catId=0;
		int id=0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			catId = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			ArrayList<Category> listCat = catDAO.getItems();
			Watch watch = watchDAO.getItemByID(id);
			request.setAttribute("listCat", listCat);
			request.setAttribute("watch", watch);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		System.out.println(id+""+catId);
		Watch item = watchDAO.getItemByID(id);
		if(item==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		String name = request.getParameter("name");	
		String detailtext = request.getParameter("detailtext");	
		String feature = request.getParameter("feature");	
		String parameters = request.getParameter("parameters");	
		Part filePart = request.getPart("picture");
		int sell = Integer.parseInt(request.getParameter("sell"));
		int selloff = Integer.parseInt(request.getParameter("selloff"));		
		
		// tao thu muc luu anh
		final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		// lay ten file
		String fileName = FileUtil.getName(filePart); 
		// doi ten file
		String picture = "";
		if(fileName.isEmpty()) {
			picture = item.getPicture();
		}else {
			 picture = FileUtil.rename(fileName);
		}
		// tao duong dan
		String filePathName = dirPathName+File.separator+picture;
		Watch watch = new Watch(id, name, detailtext, feature, parameters, picture, sell, selloff, catId, 0, 0);
		if(watchDAO.editItem(watch)>0 ) {			
			if(!fileName.isEmpty()) {
				// xoa file
				String oldFilePartName = dirPathName+File.separator+item.getPicture();
				File oldFile = new File(oldFilePartName);
				//kiem tra file co ton tai
				if(oldFile.exists()) {
					oldFile.delete();
				}
				//ghi file
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath()+"/admin/watch?msg=2");
			return;
		}else {
			ArrayList<Category> listCat = catDAO.getItems();
			request.setAttribute("listCat", listCat);			 
			request.setAttribute("watch", watch);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp?err=2");
			rd.forward(request, response);
			return;
		}
	}

}
