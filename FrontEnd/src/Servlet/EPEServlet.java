package Servlet;

import DataBean.UserBean;
import EJBInterface.UserEJBInterface;
import Servlet.Notifications.NotificationItem;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jaime on 30/03/2015.
 *
 * Application specific Servlet abstraction.
 * Takes care of session and notifications.
 */
public abstract class EPEServlet extends HttpServlet{
	final private String queueSessionId = "_NotificationQueue";
	final private String userIdSessionId = "_userId";
	final private String userBeanSessionId = "_UserBean";
	final protected String notificatioListId = "notifications";

	@EJB
	protected UserEJBInterface userEJB;

	protected void logout(HttpSession session){
		session.removeAttribute(userIdSessionId);
	}

	protected boolean isLogged(HttpSession session){
   	    return (session.getAttribute(userIdSessionId)!=null);
	}

	protected Integer getUserId(HttpSession session){
		return (int) session.getAttribute(userIdSessionId);
	}

	protected void updateUser(HttpSession session){
		if(isLogged(session)){
			Integer id = getUserId(session);
			if(id == null){
				logout(session);
				return;
			}
			UserBean user = userEJB.getUser(id);
			if(user == null){
				logout(session);
				return;
			}
			session.setAttribute(userBeanSessionId, user);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		noCache(resp);
		if(isLogged(session)) updateUser(session);
		onGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		noCache(resp);
		if(isLogged(session)) updateUser(session);
		onPost(req, resp);
	}

	private void noCache(HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
	}


	protected void addNotification(HttpSession session, NotificationType type, String notification){
		List<NotificationItem> queue = getNotificationQueue(session);
		NotificationItem notificationItem = new NotificationItem(type, notification);
		queue.add(notificationItem);
	}



	private List<NotificationItem> getNotificationQueue(HttpSession session){
		List<NotificationItem> queue = (List<NotificationItem>)session.getAttribute(queueSessionId);
		if(queue == null ){
			queue = new LinkedList<>();
			session.setAttribute(queueSessionId, queue);
		}
		return queue;
	}

	protected boolean hasNotifications(HttpSession session){
		return !getNotificationQueue(session).isEmpty();
	}

	protected List<NotificationItem> popNotifications(HttpSession session){
		List<NotificationItem> queue = getNotificationQueue(session);
		session.removeAttribute(queueSessionId);
		return queue;
	}

	protected void showNotifications(HttpServletRequest req){
		if(hasNotifications(req.getSession())) {
			List<NotificationItem> prev = (List<NotificationItem>) req.getAttribute(notificatioListId);
			List<NotificationItem> novas = popNotifications(req.getSession());
			if(prev!=null) novas.addAll(prev);
			req.setAttribute(notificatioListId, novas);
		}
	}


	//Stuff to be overridden.
	protected abstract void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	protected abstract void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}

