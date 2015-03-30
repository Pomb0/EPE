package Beans;

import DataBean.ItemBean;
import EJBInterface.InventoryEJBInterface;
import JPA.Entities.PlantsEntity;
import JPA.Entities.ProductEntity;

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
            e.printStackTrace();
        }

        return false;
    }

    private PlantsEntity getPlant(String type) {
        Query query =  entityManager.createQuery("FROM PlantsEntity u WHERE u.type = :t") ;
        query.setParameter("t", type);
        return (PlantsEntity)query.getSingleResult();
    }
}
