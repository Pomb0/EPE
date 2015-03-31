package EJBInterface;

import DataBean.ItemBean;

import javax.ejb.Remote;
import javax.persistence.Column;
import java.util.List;

@Remote
public interface InventoryEJBInterface {
    boolean addItem(ItemBean product);
    ItemBean getItemBean(int id);
    List<ItemBean> getInventory();
    boolean modifyItem(int id, ItemBean newItem);
}
