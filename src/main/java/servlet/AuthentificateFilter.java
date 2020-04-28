package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;

@WebFilter(filterName = "admin", urlPatterns = "/admin/*")
public class AuthentificateFilter implements Filter {
	UserDao myUserDao;

	public void init(FilterConfig filterconfig) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		HttpSession session = httpServletRequest.getSession();
		
		String mdp = null;
		mdp = (String) session.getAttribute("password");
		String key = null;
		key = (String) session.getAttribute("username");

		myUserDao = new UserDao();

		try {
			if (myUserDao.Auth(key, mdp) != null) {
				session.setAttribute("admin", "true");
			} else {
				session.setAttribute("admin", "false");
			}
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void destroy() {
	}
}
