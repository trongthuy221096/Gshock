package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import model.bean.Picture;
import model.dao.PictureDAO;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminAddPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PictureDAO pictureDAO;
    public AdminAddPictureController() {
        super();
        pictureDAO = new PictureDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/addpicture.jsp");
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
		int wid = 0;
		try {
			wid = Integer.parseInt(request.getParameter("wid"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/picture?err=1");
			return;
		}
		Part filePart = request.getPart("picture");
		final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		String fileName = FileUtil.getName(filePart); 
		String picture = FileUtil.rename(fileName);
		String filePathName = dirPathName+File.separator+picture;
		
		Picture item = new Picture(0, picture, wid);
		
		if(pictureDAO.addItem(item)>0 ) {			
			//ghi file
			if(!fileName.isEmpty()) {
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath()+"/admin/picture?msg=1");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/addpicture.jsp?err=2");
			rd.forward(request, response);
			return;
		}
	}

}
