package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Contact;
import model.bean.Oder;
import model.bean.Oderitem;
import util.DBConnectionUtil;
import util.DefineUtil;

public class OderDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int getnumberOfOder() {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM shopoder";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && st !=null&& rs!=null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}		
		return result;
	}

	public ArrayList<Oder> getPagination(int offset) {
		ArrayList<Oder> listOder = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoder ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Oder oder = new Oder(rs.getInt("id"), rs.getString("fullname"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("adress"), rs.getString("code_oder"), rs.getInt("userid"), rs.getInt("payment"), rs.getString("text"));
				listOder.add(oder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null&& rs!=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		return listOder;
	}

	public Oder getItemById(int id) {
		Oder oder = null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoder WHERE id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				 oder = new Oder(rs.getInt("id"), rs.getString("fullname"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("adress"), rs.getString("code_oder"), rs.getInt("userid"), rs.getInt("payment"), rs.getString("text"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null&& rs!=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		return oder;
	}

	public ArrayList<Oder> getItemsSearch(String name) {
		ArrayList<Oder>listOder = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoder WHERE email LIKE  ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,"%"+name+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				Oder oder = new Oder(rs.getInt("id"), rs.getString("fullname"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("adress"), rs.getString("code_oder"), rs.getInt("userid"), rs.getInt("payment"), rs.getString("text"));
				listOder.add(oder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null && rs!=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}	
		return listOder;
	}
}
