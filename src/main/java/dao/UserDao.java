package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	User u = null;

	public UserDao() {
		con = null;
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
		}
		try {
			String url = "jdbc:mysql://mysql-crud.alwaysdata.net:3306/crud_exo";
			con = DriverManager.getConnection(url, "crud", "boubis13");
		} catch (Exception e) {
			System.out.println("connexion impossible");
		}
		return con;
	}

	public static void closeConnexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public User Auth(String nom, String mp) throws SQLException {
		Connection con = null;
		try {
			con = UserDao.getConnection();
			ps = con.prepareStatement("SELECT nom FROM users WHERE nom = ?");
			ps.setString(1, nom);
			rs = ps.executeQuery();
			rs.next();
			rs.getString(1);
			if (rs.getString(1).equals(nom)) {
			}
		} catch (SQLException sqlE) {
			return u;
		}
		try {
			con = UserDao.getConnection();
			ps = con.prepareStatement("SELECT id, nom, prenom, motdepasse FROM users WHERE motDePasse = ?");
			ps.setString(1, mp);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(4).equals(mp)) {
					u = new User();
					u.setId(rs.getInt(1));
					u.setNom(rs.getString(2));
					u.setPrenom(rs.getString(3));
					u.setMp(rs.getString(4));
				}
			}
			closeConnexion(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	public List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		try {
			con = UserDao.getConnection();
			ps = con.prepareStatement("SELECT id, nom, prenom, motdepasse from users");
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setNom(rs.getString(2));
				u.setPrenom(rs.getString(3));
				u.setMp(rs.getString(4));
				list.add(u);
			}
			closeConnexion(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public static int insert(User u) {
		int status = 0;
		Connection con = null;
		con = UserDao.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO users (id,nom, prenom, motdepasse) values (?,?,?,?)");
			ps.setInt(1, u.getId());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getMp());
			status = ps.executeUpdate();
			closeConnexion(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static User getUserById(String id) {
		User u = null;
		Connection con = null;
		try {
			con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from users WHERE id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setMp(rs.getString("motdepasse"));
			}
			closeConnexion(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	public static int delete(User u) {
		int status = 0;
		Connection con = null;
		
		try {
			con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
			closeConnexion(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}

//	public static int update(User u) {
//		int status = 0;
//		Connection con = null;
//		try {
//			con = UserDao.getConnection();
//			PreparedStatement ps = con.prepareStatement("UPDATE users set id=?, nom=?, prenom=?, motdepasse=?");
//			ps.setInt(1, u.getId());
//			ps.setString(2, u.getNom());
//			ps.setString(3, u.getPrenom());
//			ps.setString(4, u.getMp());
//			status = ps.executeUpdate();
//			closeConnexion(con);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return status;
//	}
//	
}