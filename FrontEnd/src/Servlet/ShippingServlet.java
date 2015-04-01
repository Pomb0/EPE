package Servlet;

import DataBean.OrderBean;
import EJBInterface.OrderEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jaime on 01/04/2015.
 *
 *
 */

public class ShippingServlet extends EPEServlet{
	@EJB
	OrderEJBInterface orderEJB;
	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RequestDispatcher rd;

		if( req.getParameterMap().containsKey("id") ){ //Show one
			try{
				int id = Integer.parseInt(req.getParameter("id"));
				OrderBean order = orderEJB.getOrder(id);
				if(order!=null){
					req.setAttribute("order", order);
					rd = req.getRequestDispatcher("WEB-INF/jsp/order/view.jsp");
				}else{
					addNotification(session, NotificationType.ERROR, "Order does not exist.");
					resp.sendRedirect("shipping");
					return;
				}
			}catch (Exception e){
				addNotification(session, NotificationType.ERROR, "Order does not exist.");
				resp.sendRedirect("shipping");
				return;
			}
		}else if( req.getParameterMap().containsKey("ship") ){ //Ship dat thing
			try{
				int id = Integer.parseInt(req.getParameter("ship"));
				boolean result = orderEJB.shipOrder(id);

				if(result) addNotification(session, NotificationType.INFO, "Order shipped.");
				else addNotification(session, NotificationType.INFO, "Order failed to ship.");

			}catch (Exception e){
				addNotification(session, NotificationType.ERROR, "Order does not exist.");
				resp.sendRedirect("shipping");
				return;
			}
			resp.sendRedirect("shipping");
			return;
		}else{ //List 'em

			List<OrderBean> pendingOrders = orderEJB.getPendingList();
			List<OrderBean> shippedOrders = orderEJB.getShippedList();

			if(pendingOrders==null) pendingOrders = new LinkedList<>();
			if(shippedOrders==null) shippedOrders = new LinkedList<>();

			req.setAttribute("pendingOrders", pendingOrders);
			req.setAttribute("shippedOrders", shippedOrders);

			rd = req.getRequestDispatcher("WEB-INF/jsp/order/list.jsp");

		}

		showNotifications(req);
		rd.forward(req, resp);

	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
