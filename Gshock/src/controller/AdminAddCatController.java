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

import model.bean.Category;
import model.dao.CatDAO;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;
    public AdminAddCatController() {
        super();
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
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/addcat.jsp");
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
		String name = request.getParameter("name");
		int parent = 0;
		try {
			parent	 = Integer.parseInt(request.getParameter("parent"));
		} catch (NumberFormatException e) {
			
		}
		
		try {
			if("".equals(name)) {
				response.sendRedirect(request.getContextPath()+"/admin/cat/add?err=1");
				return;
			}else {
				Part filePart = request.getPart("picture");
				final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
				File dirFile = new File(dirPathName);
				if(!dirFile.exists()) {
					dirFile.mkdirs();
				}
				String fileName = FileUtil.getName(filePart); 
				String picture = FileUtil.rename(fileName);
				String filePathName = dirPathName+File.separator+picture;
				Category cat = new Category(0, name,parent,picture);
				if(catDAO.addItem(cat) > 0) {
					if(!fileName.isEmpty()) {
						filePart.write(filePathName);
					}
					response.sendRedirect(request.getContextPath()+"/admin/cat?msg=1");
					return;
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/addcat.jsp?err=2");
					rd.forward(request, response);
					return;
				}
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/addcat.jsp?err=1");
			rd.forward(request, response);
			
		}
		
		
	}

}
