package Servlet;

import DataBean.UserBean;
import EJBInterface.LogEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Jaime on 31/03/2015.
 *
 * Takes care of logins and logouts
 */
public class SessionServlet extends EPEServlet {
	@EJB
	LogEJBInterface logBean;
	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(isLogged(session) && req.getParameterMap().containsKey("logout")){  //Logout
			UserBean userBean = getUserBean(session);
			logBean.addLog(LogEJBInterface.LogType.SESSION, new Date() + " - LogOut - User: " + userBean.getId() +  " : " + userBean.getUsername() + " - IP: " + req.getRemoteAddr());
			logout(session);
			resp.sendRedirect("index");
			return;
		}

		if(isLogged(session)){resp.sendRedirect("index"); return;} //Refuse logged
		showNotifications(req);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(req.getParameterMap().containsKey("reg")){
			resp.sendRedirect("register");
			return;
		}

		if(req.getParameterMap().containsKey("log")){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(username!=null && password!=null) {
				if( !logIn(session, username, password) ){
					addNotification(session, NotificationType.ERROR, "Wrong username and/or password.");

				}else{
					UserBean userBean = getUserBean(session);
					logBean.addLog(LogEJBInterface.LogType.SESSION, new Date() + " - LogIn - User: " + userBean.getId() +  " : " + userBean.getUsername() + " - IP: " + req.getRemoteAddr());

					resp.sendRedirect("index");
					return;
				}
			}
		}
		showNotifications(req);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(req, resp);
	}
}
