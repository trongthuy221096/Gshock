package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Watch;
import model.dao.WatchDAO;
import util.AuthUtil;



public class AdminDelWatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WatchDAO watchDAO;   

    public AdminDelWatchController() {
        super();
        watchDAO = new WatchDAO();
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
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/watch?err=1");
			return;
		}
		Watch item = watchDAO.getItemByID(id);
		if(item==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/editwatch.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		
		
		if(watchDAO.dellItem(id)>0) {
			final String dirPathName = request.getServletContext().getRealPath("/templates/admin/assets/img");
			String picture = item.getPicture();
			if(!picture.isEmpty()) {
				String filePathName  = dirPathName + File.separator+picture;
				File file  = new File(filePathName);
				if(file.exists()) {
					file.delete();
				}
			}
			response.sendRedirect(request.getContextPath()+"/admin/watch?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/watch?err=2");
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
