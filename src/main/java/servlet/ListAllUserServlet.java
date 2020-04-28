package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

@WebServlet("/admin/listalluser")
public class ListAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	UserDao myUserDao;
	List<User> listUser;

	public ListAllUserServlet() {
		super();
		listUser = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executeQuery(request, response);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executeQuery(request, response);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void executeQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		myUserDao = new UserDao();

		listUser = myUserDao.getAllRecords();
		request.setAttribute("list", listUser);
		RequestDispatcher rd = request.getRequestDispatcher("/viewusers.jsp");
		rd.forward(request, response);
	}

}
