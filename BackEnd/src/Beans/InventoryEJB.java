package Beans;

import DataBean.ItemBean;
import EJBInterface.InventoryEJBInterface;
import EJBInterface.UserEJBInterface;
import JPA.Entities.ProductEntity;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InventoryEJB implements InventoryEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    @Override
    public boolean addItem(ItemBean product) {
        try {
            ProductEntity newProduct = new ProductEntity()
                    .setProductCode;
            newUser
                    .setUsername(username)
                    .setPassword(password);
            entityManager.persist(newUser);
        }catch (Exception e){
            while(e.getCause()!=null) e = (Exception) e.getCause();
            if(e.getMessage().contains("'" + username + "'")) return UserEJBInterface.UserCreationResult.DUPLICATE_USER;
            return UserEJBInterface.UserCreationResult.UNKNOWN;
        }
        return UserEJBInterface.UserCreationResult.OK;
        return false;
    }
}
