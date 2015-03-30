package Beans;

import DataBean.ItemBean;
import EJBInterface.InventoryEJBInterface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InventoryEJB implements InventoryEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    @Override
    public boolean addItem(ItemBean product) {
        return false;
    }
}
