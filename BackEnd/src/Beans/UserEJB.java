package Beans;

import DataBean.UserBean;
import EJBInterface.UserEJBInterface;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class UserEJB implements UserEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

  //Creates user, returns enum UserCreationResult
    @Override
    public UserCreationResult createUser(String username, String password) {
        try {
            UserEntity newUser = new UserEntity()
                    .setUsername(username)
                    .setPassword(password);
            entityManager.persist(newUser);
        }catch (Exception e){
            while(e.getCause()!=null) e = (Exception) e.getCause();
            if(e.getMessage().contains("'" + username + "'")) return UserCreationResult.DUPLICATE_USER;
            return UserCreationResult.UNKNOWN;
        }
        return UserCreationResult.OK;
    }

    //Authenticates a user, returns true if authentication success, else, false.
    @Override
    public UserBean authenticate(String username, String password) {
        UserBean result = getUser(username);

        if (result!=null && result.getPassword().equals(password)) return result.setPassword(null);
        return null;
    }


    @Override
    public UserBean getUser(int id) {
        try {
            Query query = entityManager.createQuery("FROM UserEntity o WHERE o.id = :t");
            query.setParameter("t", id);
            List<UserEntity> users = (List<UserEntity>)query.getResultList();

            if(users != null && !users.isEmpty()) return users.get(0).toBean();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public UserBean getUser(String username){
        try {
            Query query = entityManager.createQuery("FROM UserEntity o WHERE o.username = :t");
            query.setParameter("t", username);
            List<UserEntity> users = (List<UserEntity>)query.getResultList();

            if(users != null && !users.isEmpty()) return users.get(0).toBean();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
