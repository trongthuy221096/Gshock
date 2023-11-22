package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Contact;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ContactDAO {
	private Connection conn ;
	private DBConnectionUtil  dbConnectionUtil = new DBConnectionUtil();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int getnumberOfContact() {
		int result =0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM contacts";
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

	public ArrayList<Contact> getPagination(int offset) {
		ArrayList<Contact> listContact = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM contacts ORDER BY id DESC LIMIT ? ,?";		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("detailtext"));
				listContact.add(contact);
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
		return listContact;
	}

	public int dellItem(int id) {
		int result=0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM contacts WHERE id = ? ";
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

	public ArrayList<Contact> getItemsSearch(String name) {
		ArrayList<Contact>listContact = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM contacts WHERE email LIKE ? || numberphone LIKE ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,"%" + name + "%" );
			pst.setString(2,"%" + name + "%" );
			rs = pst.executeQuery();
			while(rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("detailtext"));
				listContact.add(contact);
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
		return listContact;
	}

	public int addItem(Contact cat) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql="INSERT INTO contacts(name,numberphone,email,detailtext) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cat.getName());
			pst.setInt(2, cat.getNumberphone());
			pst.setString(3, cat.getEmail());
			pst.setString(4, cat.getDetailtext());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null && pst !=null ) {
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

	public ArrayList<Contact> getItemsByWid(int id) {
		ArrayList<Contact>listContact = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql="SELECT * FROM contacts WHERE  wid = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getInt("numberphone"), rs.getString("email"), rs.getString("detailtext"));
				listContact.add(contact);
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
		return listContact;
	}
	
	
}
