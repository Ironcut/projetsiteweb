package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;

@WebServlet("/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User userToUpdate;

	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);

		if (session.getAttribute("admin") == "true") {
			User userToUpdate = UserDao.getUserById(request.getParameter("id"));

			request.setAttribute("userToUpdate", userToUpdate);

			rd = request.getRequestDispatcher("../updateuser.jsp");
			rd.forward(request, response);

		} else {
			rd = request.getRequestDispatcher("../errorlogin.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = new User();
		u.setId(request.getParameter("id"));
		u.setNom(request.getParameter("name"));
		u.setPrenom(request.getParameter("surname"));
		u.setMp(request.getParameter("password"));
		int i = UserDao.update(u);
		if (i == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("../success.jsp");
			rd.forward(request, response);
		}
		if (i == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/errorlogin.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/errorlogin.jsp");
			rd.forward(request, response);
		}
	}
}
