package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Comment;
import util.DBConnectionUtil;

public class CommentDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<Comment> getItems() {
		ArrayList<Comment> listCmt = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM comments";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Comment cmt = new Comment(rs.getInt("id"), rs.getString("name"), rs.getString("comment"), rs.getInt("userid"),rs.getInt("reviewid"));
				listCmt.add(cmt);
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
		
		return listCmt;
	}

	public int addItem(Comment cmt) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO  comments(name,comment,userid,reviewid) VALUES(?,?,?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, cmt.getName());
			pst.setString(2, cmt.getComment());
			pst.setInt(3, cmt.getUserid());
			pst.setInt(4, cmt.getReviewid());
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

	public int delItem(int id) {
		int result=0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM comments WHERE id = ? ";
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
