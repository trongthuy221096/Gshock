package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Oderitem;
import model.bean.Review;
import model.bean.ShopOder;
import model.dao.OderitemDAO;
import model.dao.ReviewDAO;
import model.dao.ShopOderDAO;


public class PublicAddOderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDAO reviewDAO;
	private ShopOderDAO shopoderDAO = new ShopOderDAO();
	private OderitemDAO oderitemDAO = new OderitemDAO();
    public PublicAddOderController() {
        super();
        reviewDAO = new ReviewDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
