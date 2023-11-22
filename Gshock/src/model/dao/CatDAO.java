package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Picture;
import util.DBConnectionUtil;
import util.DefineUtil;

public class CatDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<Category> getItems() {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"),
						rs.getString("catpicture"), rs.getInt("lever"));
				listCat.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && st != null && rs != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listCat;
	}

	public int addItem(Category cat) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO categories(name,parent,catpicture) VALUES(?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cat.getName());
			pst.setInt(2, cat.getParent());
			pst.setString(3, cat.getPicture());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null) {
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

	public int editItem(Category cat) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE categories SET name = ?,parent = ?, catpicture=? WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cat.getName());
			pst.setInt(2, cat.getParent());
			pst.setString(3, cat.getPicture());
			pst.setInt(4, cat.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null) {
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

	public Category getItemById(int id) {
		Category cat = null;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM  categories WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"),
						rs.getString("catpicture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cat;
	}

	public int dellItem(int id) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE  FROM categories WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null) {
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

	public ArrayList<Category> getItemsSearch(String name) {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories WHERE name LIKE ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"),
						rs.getString("catpicture"));
				listCat.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listCat;
	}

	public int numberOfCat() {
		int count = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM categories";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && st != null && rs != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	public ArrayList<Category> getPagination(int offset) {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories ORDER BY id DESC LIMIT ? ,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"),
						rs.getString("catpicture"));
				listCat.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listCat;
	}

	public ArrayList<Category> getItem6() {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM `categories` WHERE parent !=0 LIMIT 0 ,6";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"),
						rs.getString("catpicture"));
				listCat.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null && st != null && rs != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listCat;
	}

}
