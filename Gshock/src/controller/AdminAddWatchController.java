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
public class AdminAddWatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WatchDAO watchDAO;
	private CatDAO catDAO;
    public AdminAddWatchController() {
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
		ArrayList<Category> listCat = catDAO.getItems();
		request.setAttribute("listCat", listCat);		
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/addwatch.jsp");
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
		try {
			catId = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/addwatch.jsp?err=1");
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
		String picture = FileUtil.rename(fileName);
		// tao duong dan
		String filePathName = dirPathName+File.separator+picture;
		System.out.println(filePathName);
		Watch watch = new Watch(0, name, detailtext, feature, parameters, picture, sell, selloff, catId, 0, 0);
		if(watchDAO.addItem(watch)>0 ) {			
			//ghi file
			if(!fileName.isEmpty()) {
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath()+"/admin/watch?msg=1");
			return;
		}else {
			ArrayList<Category> listCat = catDAO.getItems();
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/addwatch.jsp?err=2");
			rd.forward(request, response);
			return;
		}
	}

}
