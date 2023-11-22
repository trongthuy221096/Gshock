package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Payment;
import util.DBConnectionUtil;
import util.DefineUtil;

public class PaymentDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int getnumberOfPay() {
		int count=0;
		conn= dbConnectionUtil.getConnection();
		String sql="SELECT COUNT(*) AS count FROM payment";		
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && st !=null && rs!=null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}}			
		return count;	
	}

	public ArrayList<Payment> getPagination(int offset) {
		ArrayList<Payment> listPay = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM payment ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Payment pay = new Payment(rs.getInt("id"), rs.getString("name"), rs.getInt("number_card"), rs.getString("password"), rs.getInt("user_id"));
				listPay.add(pay);
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
		return listPay;
	}

	public int addItem(Payment pay) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO payment(name,number_card,password,user_id) VALUES(?,?,?,?)";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, pay.getName());
			pst.setInt(2, pay.getNumbercard());
			pst.setString(3, pay.getPassword());
			pst.setInt(4, pay.getUserid());
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

	public Payment getItemById(int id) {
		Payment pay = null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM payment WHERE id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				 pay = new Payment(rs.getInt("id"), rs.getString("name"), rs.getInt("number_card"), rs.getString("password"), rs.getInt("user_id"));
				
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
		return pay;
	}

	public int editItem(Payment pay) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE payment SET name = ? ,number_card = ?,password = ?,user_id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, pay.getName());
			pst.setInt(2, pay.getNumbercard());
			pst.setString(3, pay.getPassword());
			pst.setInt(4, pay.getUserid());
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

	public int dellItem(int id) {
		int result=0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM payment WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
}
