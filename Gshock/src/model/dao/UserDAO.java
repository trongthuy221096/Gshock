package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.User;
import model.bean.Watch;
import util.DBConnectionUtil;
import util.DefineUtil;

public class UserDAO {
	private Connection conn;
	private  DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public boolean hasUsername(String username) {
		
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst != null && conn != null || rs!=null) {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}			
		}	
		return false;
	}

	public int addItem(User user) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO users(username,password,fullname,email,numberphone,role) VALUES(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getNumberphone());
			pst.setInt(6, user.getRole());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst != null && conn != null ) {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}			
		}	
		return result;
	}

	public int getnumberOfUser() {
		int count=0;
		conn= dbConnectionUtil.getConnection();
		String sql="SELECT COUNT(*) AS count FROM users";		
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

	public ArrayList<User> getPagination(int offset) {
		ArrayList<User> listUser = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM users ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				User  user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getInt("numberphone"), rs.getInt("role"),rs.getInt("pay_id"),rs.getInt("numbercard"),rs.getString("passwordcard"));
				listUser.add(user);
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
		return listUser;
	}

	public User getItemById(int id) {
			User user = null;
			conn = dbConnectionUtil.getConnection();
			String sql="SELECT * FROM  users WHERE id = ?";
			try {
				pst= conn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()) {
					 user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getInt("numberphone"), rs.getInt("role"),rs.getInt("pay_id"),rs.getInt("numbercard"),rs.getString("passwordcard"));
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
			return user;
	}

	public int editItem(User user) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE users SET password = ?,fullname = ?, email = ? , numberphone = ?,role = ?  WHERE id = ? ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getFullname());
			pst.setString(3, user.getEmail());
			pst.setInt(4, user.getNumberphone());
			pst.setInt(5, user.getRole());
			pst.setInt(6, user.getId());
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
		conn= dbConnectionUtil.getConnection();
		String sql="DELETE FROM users WHERE id = ?";		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && st !=null ) {
				try {
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}}			
		return result;		
	}

	public User existUser(String username, String password) {
		User user = null;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM users  WHERE username = ? && password = ?";		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs= pst.executeQuery();
			if(rs.next()){
				 user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getInt("numberphone"), rs.getInt("role"),rs.getInt("pay_id"),rs.getInt("numbercard"),rs.getString("passwordcard"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs !=null && pst != null && conn != null) {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}			
		}
		return user;
	}

	public int getnumberOfWatch(String search) {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM users WHERE username LIKE ? ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,"%"+search+"%");
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

	public ArrayList<User> getItemSearch(String search) {
		ArrayList<User> listUser = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM users WHERE username LIKE ? ";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,"%"+search+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getInt("numberphone"), rs.getInt("role"),rs.getInt("pay_id"),rs.getInt("numbercard"),rs.getString("passwordcard"));
				listUser.add(user);
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
		return listUser;
	}
	

	
	
}
