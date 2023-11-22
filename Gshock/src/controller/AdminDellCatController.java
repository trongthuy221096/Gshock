package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;
import util.AuthUtil;

public class AdminDellCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO;  

    public AdminDellCatController() {
        super();
        catDAO = new CatDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=1");
			return;
		}
		Category item = catDAO.getItemById(id);
		if(catDAO.dellItem(id)>0) {
			final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
			String picture = item.getPicture();
			if(!picture.isEmpty()) {
				String filePathName  = dirPathName + File.separator+picture;
				File file  = new File(filePathName);
				if(file.exists()) {
					file.delete();
				}
			}
			response.sendRedirect(request.getContextPath()+"/admin/cat?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=2");
			return;
		}
	}

}
