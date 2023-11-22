package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Picture;
import model.bean.Watch;
import util.DBConnectionUtil;
import util.DefineUtil;

public class PictureDAO {
	private Connection conn ;
	private DBConnectionUtil  dbConnectionUtil = new DBConnectionUtil();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int addItem(Picture item) {
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="INSERT INTO picture(picture,wid) VALUES(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,item.getPicture());
			pst.setInt(2, item.getWid());
			result = pst.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null && conn!=null) {
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

	public int getnumberOfPicture() {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM picture";
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

	public ArrayList<Picture> getPagination(int offset) {
		ArrayList<Picture> listPicture = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM picture ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Picture item = new Picture(rs.getInt("id"), rs.getString("picture"), rs.getInt("wid"));
				listPicture.add(item);
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
		return listPicture;
	}

	public Picture getItemByID(int id) {
		Picture item = null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM picture WHERE id =?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				 item = new Picture(rs.getInt("id"), rs.getString("picture"), rs.getInt("wid"));
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
		return item;
	}
	public ArrayList<Picture> getItemByWid(int wid) {
		ArrayList<Picture>listPicture = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM picture WHERE wid =?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, wid);
			rs=pst.executeQuery();
			while(rs.next()) {
				 Picture item = new Picture(rs.getInt("id"), rs.getString("picture"), rs.getInt("wid"));
				 listPicture.add(item);
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
		return listPicture;
	}
	public int editItem(Picture item) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE picture SET picture =? , wid =? WHERE id = ? ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, item.getPicture());
			pst.setInt(2, item.getWid());
			pst.setInt(3, item.getId());
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

	public int getnumberOfPicture(String search) {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM picture WHERE wid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, search);
			rs = pst.executeQuery();
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

	public ArrayList<Picture> getItemSearch(String search) {
		ArrayList<Picture> listPicture = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM picture  WHERE wid = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, search);
			rs = pst.executeQuery();
			while(rs.next()) {
				Picture item = new Picture(rs.getInt("id"), rs.getString("picture"), rs.getInt("wid"));
				listPicture.add(item);
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
		return listPicture;
	}
	
}
