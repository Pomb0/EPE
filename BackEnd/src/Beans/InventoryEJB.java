package Beans;

import DataBean.ItemBean;
import EJBInterface.InventoryEJBInterface;
import EJBInterface.UserEJBInterface;
import JPA.Entities.PlantsEntity;
import JPA.Entities.ProductEntity;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class InventoryEJB implements InventoryEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    @Override
    public boolean addItem(ItemBean product) {
        try {
            PlantsEntity plant = getPlant(product.getPlanta().getType());
            if(plant == null)
                return false;


            ProductEntity newProduct = new ProductEntity()
                    .setProductCode(product.getProductCode())
                    .setDescription(product.getDescription())
                    .setPrice(product.getPrice())
                    .setPlanta(plant)
                    .setStock(product.getStock());

            entityManager.persist(newProduct);
            return true;
        }catch (Exception e){
            while(e.getCause()!=null) e = (Exception) e.getCause();

        }

        return false;
    }

    private PlantsEntity getPlant(String type) {
        Query query =  entityManager.createQuery("from PlantsEntity u where u.type = :t") ;
        query.setParameter("t", type);
        return (PlantsEntity)query.getSingleResult();
    }
}
