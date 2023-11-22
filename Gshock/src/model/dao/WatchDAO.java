package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Watch;
import util.DBConnectionUtil;
import util.DefineUtil;

public class WatchDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st ;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int getnumberOfWatch() {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM watchs";
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

	public ArrayList<Watch> getPagination(int offset) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public int addItem(Watch watch) {
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="INSERT INTO watchs(name,detail_text,feature,parameters,picture,sell,sell_off,cat_id,number_vote,result_vote) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,watch.getName() );
			pst.setString(2,watch.getDetailtext());
			pst.setString(3,watch.getFeature());
			pst.setString(4, watch.getParameters());
			pst.setString(5, watch.getPicture());
			pst.setInt(6,watch.getSell());
			pst.setInt(7,watch.getSelloff());
			pst.setInt(8,watch.getCatid());
			pst.setInt(9,watch.getNumbervote());
			pst.setFloat(10,watch.getResultvote());
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

	public Watch getItemByID(int id) {
		Watch watch = null;
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE id = ?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				 watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				
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
		return watch;
	}

	public int editItem(Watch watch) {
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="UPDATE watchs SET name = ?,detail_text =?,feature =? ,parameters =?,picture =?,sell =? ,sell_off =? ,cat_id =? WHERE id =? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,watch.getName());
			pst.setString(2,watch.getDetailtext());
			pst.setString(3,watch.getFeature());
			pst.setString(4,watch.getParameters());
			pst.setString(5,watch.getPicture());
			pst.setInt(6,watch.getSell());
			pst.setInt(7,watch.getSelloff());
			pst.setInt(8,watch.getCatid());
			pst.setInt(9,watch.getId());
			result = pst.executeUpdate();
			System.out.println(watch.getName());
			System.out.println(watch.getId());
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
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="DELETE FROM watchs WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);		
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

	public ArrayList<Watch> getItemSearch(String search) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE name LIKE ? || parameters LIKE ? || feature LIKE ? ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,"%"+search+"%");
			pst.setString(2,"%"+search+"%");
			pst.setString(3,"%"+search+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public int getnumberOfWatch(String search) {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM watchs WHERE name LIKE ? || parameters LIKE ? || feature LIKE ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,"%"+search+"%");
			pst.setString(2,"%"+search+"%");
			pst.setString(3,"%"+search+"%");
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

	public ArrayList<Watch> getPagination8(int offset) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE8);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getPagination8(int catid, int offset) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id = ? ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, catid);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE8);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public int getnumberOfWatch(int catid) {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM watchs WHERE cat_id = ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,catid);
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

	public ArrayList<Watch> getNewItemByDesc() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY id DESC ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItemResultVote() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY result_vote DESC ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItemBySellDesc() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY sell_off DESC ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItemBySellAsc() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs ORDER BY sell_off ASC ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public int Updatevote(int numbervote, float resultvote,int wid) {
		int result = 0;	
		conn = dbConnectionUtil.getConnection();
		String sql="UPDATE watchs SET number_vote =?,result_vote=? WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, numbervote);
			pst.setFloat(2, resultvote);
			pst.setInt(3, wid);
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

	public ArrayList<Watch> getItems4Gshock() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id=4  ORDER BY id DESC LIMIT 0 ,4";		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItemsBabyg4() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id=3  ORDER BY id DESC LIMIT 0 ,4";		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItemsVintage4() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id=8  ORDER BY id DESC LIMIT 0 ,4";		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> getItems2Gshock() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id=4  ORDER BY id DESC LIMIT 0 ,2";		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}

	public ArrayList<Watch> listwatchbabyg2() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM watchs WHERE cat_id=3  ORDER BY id DESC LIMIT 0 ,2";		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Watch watch = new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("detail_text"), rs.getString("feature"), rs.getString("parameters"), rs.getString("picture"), rs.getInt("sell"), rs.getInt("sell_off"), rs.getInt("cat_id"), rs.getInt("number_vote"), rs.getFloat("result_vote"));
				listWatch.add(watch);
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
		return listWatch;
	}
	
	
}
