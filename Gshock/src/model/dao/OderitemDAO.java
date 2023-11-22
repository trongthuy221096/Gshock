package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Oderitem;
import model.bean.Watch;
import util.DBConnectionUtil;
import util.DefineUtil;

public class OderitemDAO {
	private Connection conn ;
	private DBConnectionUtil  dbConnectionUtil = new DBConnectionUtil();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int getnumberOfOderitem() {
		int count=0;
		conn= dbConnectionUtil.getConnection();
		String sql="SELECT COUNT(*) AS count FROM shopoderitem";		
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

	public ArrayList<Oderitem> getPagination(int offset) {
		ArrayList<Oderitem> listOderitem = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoderitem ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Oderitem oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
				listOderitem.add(oderitem);
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
		return listOderitem;
	}

	public int addItem(Oderitem oderitem) {
		int result = 0;
		conn= dbConnectionUtil.getConnection();
		String sql="INSERT INTO shopoderitem(name,quality,sell,amount,userid,wid,oder_id) VALUES(?,?,?,?,?,?,?)";		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,oderitem.getName() );
			pst.setInt(2, oderitem.getQualiti());
			pst.setInt(3, oderitem.getSell());
			pst.setInt(4, oderitem.getAmount());
			pst.setInt(5, oderitem.getUserid());
			pst.setInt(6, oderitem.getWid());
			pst.setInt(7, oderitem.getOderid());
			result = pst.executeUpdate();
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
		return result;	
	}

	public ArrayList<Oderitem> getItems() {
		ArrayList<Oderitem> listOderitem = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoderitem ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Oderitem oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
				listOderitem.add(oderitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return listOderitem;
	}

	public int setQuality(int wid, int quality) {
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="UPDATE shopoderitem SET quality = ? WHERE wid =? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, quality);
			pst.setInt(2, wid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
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

	public int dellItem(int id) {
		int result=0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM shopoderitem WHERE id = ? ";
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

	public Oderitem getItemByID(int id) {
		Oderitem oderitem = null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM  shopoderitem WHERE id = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
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
		return oderitem;
	}
	public ArrayList<Oderitem> getItemByUserLogin(int wid) {
		ArrayList<Oderitem> listOder = new ArrayList<Oderitem>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM  shopoderitem WHERE userid = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, wid);
			rs = pst.executeQuery();
			if(rs.next()) {
				Oderitem oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
				listOder.add(oderitem);
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
		return listOder;
	}
	public int editItem(Oderitem oderitem) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE shopoderitem SET name = ?,quality = ?,sell = ?, amount=?,wid = ?,userid=?,oder_id=? WHERE id = ? ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, oderitem.getName());	
			pst.setInt(2, oderitem.getQualiti());
			pst.setInt(3, oderitem.getSell());
			pst.setInt(4, oderitem.getAmount());
			pst.setInt(5, oderitem.getWid());
			pst.setInt(6, oderitem.getUserid());
			pst.setInt(7, oderitem.getOderid());
			pst.setInt(8, oderitem.getId());
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

	public int getnumberOfOderitem(String search) {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM shopoderitem WHERE oder_id = ? ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,search);
			rs=pst.executeQuery();
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

	public ArrayList<Oderitem> getItemSearch(String search) {
		ArrayList<Oderitem> listOder = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoderitem WHERE oder_id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,search);
			rs=pst.executeQuery();
			while(rs.next()) {
				Oderitem oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
				listOder.add(oderitem);
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

	public ArrayList<Oderitem> getItemByOderId(int id) {
		ArrayList<Oderitem> listOder = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM shopoderitem WHERE oder_id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			while(rs.next()) {
				Oderitem oderitem = new Oderitem(rs.getInt("id"), rs.getString("name"), rs.getInt("quality"), rs.getInt("sell"), rs.getInt("amount"), rs.getInt("wid"), rs.getInt("userid"),rs.getInt("oder_id"));
				listOder.add(oderitem);
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

	

	
}
