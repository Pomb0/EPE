package Servlet;

import EJBInterface.UserEJBInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jaime on 30/03/2015.
 *
 * Application specific Servlet abstraction.
 * Takes care of session and notifications.
 */
public abstract class EPEServlet extends HttpServlet{
	@EJB
	protected UserEJBInterface userEJB;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		noCache(resp);
		onGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		noCache(resp);
		onPost(req, resp);
	}

	protected void noCache(HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
	}


	protected void addError(String error){

	}

	protected void addNotification(String notification){

	}

	class NotificationItem{

	}

	//Stuff to be overridden.
	protected abstract void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	protected abstract void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
