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

@WebServlet("/admin/removeUser")
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RemoveUserServlet(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("admin")=="true"){
		User u = UserDao.getUserById(request.getParameter("id"));
		int i = UserDao.delete(u);
		
		if(i==1) {
			 rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
		}
		if(i==0 ) {
			 rd = request.getRequestDispatcher("/errorlogin.jsp");
			rd.forward(request, response);
		}
		}
		else {
			rd=request.getRequestDispatcher("/errorlogin.jsp");
			rd.forward(request,response);
		}
	}
}
