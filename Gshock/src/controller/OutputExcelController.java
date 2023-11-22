package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.bean.Category;
import model.bean.Oder;
import model.bean.Oderitem;
import model.dao.CatDAO;
import model.dao.OderDAO;
import model.dao.OderitemDAO;
import util.AuthUtil;
import util.DefineUtil;


@WebServlet("/OutputExcelController")
public class OutputExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO = new CatDAO();
    private OderDAO oderDAO = new OderDAO();
    private OderitemDAO oderitemDAO = new OderitemDAO();

    public OutputExcelController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Tao file");
        //ko thấy nó chạy main e nhỉ daj ecop tu trn xuong thoi
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
        
        int id = 0;
        try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
		}
         System.out.println(id);
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
          
        //This data needs to be written (Object[])
        Oder oder = oderDAO.getItemById(id);
        ArrayList<Oderitem> listOder1 = oderitemDAO.getItemByOderId(id);
        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
        data.put(1, new Object[] {"ID", "Fullname", "NumberPhone","Email","Adress","code_oder","Text"});        
        data.put(2, new Object[] {oder.getId(),oder.getName(),oder.getNumberphone(),oder.getEmail(),oder.getAdress(),oder.getCodeoder(),oder.getText()});         
        if(listOder1!=null) {
        	data.put(3, new Object[] {"ID", "Name", "Quality","Sell","Amount"}); 
        	int i = 3;
        	for(Oderitem oderitem:listOder1) {
        		i++;
        		data.put(i, new Object[] {oderitem.getId(), oderitem.getName(), oderitem.getQualiti(),oderitem.getSell(),oderitem.getAmount()}); 
        	}
        }
        Set<Integer> keyset = data.keySet();	       
        int rownum = 0;
        for (Integer key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            System.out.println(objArr);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\BaoPPQ\\Desktop\\New folder\\howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfOder = oderDAO.getnumberOfOder();
		int numberOfPage = (int)Math.ceil((float)numberOfOder/DefineUtil.NUMBER_PER_PAGE);
		System.out.println(numberOfPage);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Oder> listOder = oderDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfOder", numberOfOder);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listOder", listOder);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/oder/indexoder.jsp?msg=4");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
