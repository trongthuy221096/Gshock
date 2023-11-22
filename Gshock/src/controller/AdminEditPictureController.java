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
public class AdminEditPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PictureDAO pictureDAO;
    public AdminEditPictureController() {
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
		int id=0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/editpicture.jsp?err=1");
			rd.forward(request, response);
			return;
		}

		Picture item = pictureDAO.getItemByID(id);
		request.setAttribute("picture", item);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/editpicture.jsp");
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
		int id=0;
		int wid = 0;
		try {
			wid = Integer.parseInt(request.getParameter("wid"));
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/picture?err=1");
			return;
		}
		Picture pt = pictureDAO.getItemByID(id);
		Part filePart = request.getPart("picture");
		final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		String fileName = FileUtil.getName(filePart); 
		String picture = "";
		if(fileName.isEmpty()) {
			picture = pt.getPicture();
		}else {
			 picture = FileUtil.rename(fileName);
		}
		String filePathName = dirPathName+File.separator+picture;
		
		Picture item = new Picture(id, picture, wid);
		
		if(pictureDAO.editItem(item)>0 ) {			
			if(!fileName.isEmpty()) {
				String oldFilePartName = dirPathName+File.separator+pt.getPicture();
				File oldFile = new File(oldFilePartName);
				if(oldFile.exists()) {
					oldFile.delete();
				}
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath()+"/admin/picture?msg=2");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/editpicture.jsp?err=2");
			rd.forward(request, response);
			return;
		}
	}

}
