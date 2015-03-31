package Servlet;

import DataBean.ItemBean;
import EJBInterface.InventoryEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jaime on 31/03/2015.
 *
 * Implements item and inventory management functions
 * List, View, Add, Modify
 */
public class ItemServlet extends EPEServlet{
	@EJB
	InventoryEJBInterface inventoryEJB;

	@Override //Takes care off list and view
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//No paramteres defaults to listing all items.
		RequestDispatcher rd;
		if (req.getParameterMap().containsKey("id")) {
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				ItemBean item = inventoryEJB.getItemBean(id);
				if (item != null) {
					req.setAttribute("itemBean", item);
					rd = req.getRequestDispatcher("WEB-INF/jsp/viewItem.jsp");

				}else{
					addNotification(session, NotificationType.ERROR, "The item you tried to view, does not exist.");
					resp.sendRedirect("item");
					return;
				}
			}catch (Exception e){
				e.printStackTrace();
				addNotification(session, NotificationType.ERROR, "The item you tried to view, does not exist.");
				resp.sendRedirect("item");
				return;
			}
		}else{
			List<ItemBean> inventory = inventoryEJB.getInventory();
			rd = req.getRequestDispatcher("WEB-INF/jsp/inventory.jsp");
		}

		showNotifications(req);
		rd.forward(req, resp);
	}

	@Override //Handles additions and editions.
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
