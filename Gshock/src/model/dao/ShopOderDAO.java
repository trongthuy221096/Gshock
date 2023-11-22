package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.Category;
import model.bean.ShopOder;
import util.DBConnectionUtil;

public class ShopOderDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int additem( ShopOder shopoder) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO shopoder(fullname,numberphone,email,adress,code_oder,userid,payment,text) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, shopoder.getFullname());
			pst.setInt(2, shopoder.getNumberphone());
			pst.setString(3, shopoder.getEmail());
			pst.setString(4, shopoder.getAdress());
			pst.setString(5, shopoder.getCodeoder());
			pst.setInt(6, shopoder.getUserid());
			pst.setInt(7, shopoder.getPayment());
			pst.setString(8, shopoder.getText());			
			result = pst.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		return result;
	}

	public  ShopOder getItemByCode(String coderoder) {
		ShopOder shopoder =null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM  shopoder WHERE code_oder = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, coderoder);
			rs = pst.executeQuery();
			if(rs.next()) {
				shopoder = new ShopOder(rs.getInt("id"), rs.getString("fullname"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("adress"), rs.getString("adress"), rs.getInt("userid"), rs.getInt("payment"), rs.getString("text"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		return shopoder;
	}
}
