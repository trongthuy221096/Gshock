package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Review;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ReviewDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int numberOfReview() {
		int count=0;
		conn= dbConnectionUtil.getConnection();
		String sql="SELECT COUNT(*) AS count FROM reviews";		
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
	public int getCountByWid(int wid) {
		int count = 0;
		String sql ="SELECT COUNT(*) AS count FROM reviews WHERE wid = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, wid);
			rs = pst.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {			
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
			}}
		
		return count;
	}
	public ArrayList<Review> getPagination(int offset) {
		ArrayList<Review> listReview = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM reviews ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Review review = new Review(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getInt("vote"), rs.getString("comment"), rs.getInt("wid"));
				listReview.add(review);
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
		return listReview;
	}

	public ArrayList<Review> getItemsSearch(String name) {
		ArrayList<Review>listReview = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM reviews WHERE email LIKE ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,"%"+name+"%" );
			rs = pst.executeQuery();
			while(rs.next()) {
				Review review = new Review(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getInt("vote"), rs.getString("comment"), rs.getInt("wid"));
				listReview.add(review);
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
		return listReview;
	}

	public int dellItem(int id) {
		int result=0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM reviews WHERE id = ? ";
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

	public int addItem(Review review) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO reviews ( fullname, email, vote, comment,wid) VALUES (?,?,?,?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, review.getFullname());
			pst.setString(2, review.getEmail());
			pst.setInt(3, review.getVote());
			pst.setString(4, review.getComment());
			pst.setInt(5, review.getWid());
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

	public ArrayList<Review> getItemsByWid(int id) {
		ArrayList<Review> listReview = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM reviews WHERE wid = ?  ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				Review review = new Review(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getInt("vote"), rs.getString("comment"), rs.getInt("wid"));
				listReview.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listReview;
	}


	
	
}
