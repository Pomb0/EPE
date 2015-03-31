package EJBInterface;

import DataBean.OrderBean;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by guilherme on 3/31/15.
 */
@Remote
public interface OrderEJBInterface {
    boolean addOrder(OrderBean order);
    List<OrderBean> getPendingList();
    List<OrderBean> getShippedList();
    OrderBean getOrder(int id);
    boolean shipOrder(int id);
}
