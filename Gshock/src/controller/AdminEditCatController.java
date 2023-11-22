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
import model.bean.Picture;
import model.dao.CatDAO;
import util.AuthUtil;
import util.FileUtil;


@MultipartConfig
public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;
    public AdminEditCatController() {
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
		int id = 0;
		try {
			 id =Integer.parseInt(request.getParameter("id")) ;
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=1");
			return;
		}
		Category cat = catDAO.getItemById(id);
		request.setAttribute("cat", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/editcat.jsp");
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
		int id = 0;
		int parent = 0;
		try {
			 id =Integer.parseInt(request.getParameter("id")) ;
			 parent =Integer.parseInt(request.getParameter("parent")) ;
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=1");
			return;
		}
		String name = request.getParameter("name");
		
		try {
			if("".equals(name)) {
				response.sendRedirect(request.getContextPath()+"/admin/cat/edit?err=1");
			}else {
				Category pt = catDAO.getItemById(id);
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
				Category cat = new Category(id, name, parent, picture);
				if(catDAO.editItem(cat) > 0) {
					if(!fileName.isEmpty()) {
						String oldFilePartName = dirPathName+File.separator+pt.getPicture();
						File oldFile = new File(oldFilePartName);
						if(oldFile.exists()) {
							oldFile.delete();
						}
						filePart.write(filePathName);
					}
					response.sendRedirect(request.getContextPath()+"/admin/cat?msg=2");
					return;
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/editcat.jsp?err=2");
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
