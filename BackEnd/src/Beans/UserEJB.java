package Beans;

import DataBean.UserBean;
import EJBInterface.UserEJBInterface;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UserEJB implements UserEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    public UserCreationResult createUser(String username, String password) {

    }

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
        Query q = entityManager.createQuery("from UserEntity u where u.username = :t");
        q.setParameter("t", username);

        UserEntity result = (UserEntity) q.getSingleResult();


        if (result == null)
            return null;
        else if (result.getPassword().equals(password)){
            return result.toBean().setPassword(null);
        }


        return null;
    }


    @Override
    public UserBean getUser(int id) {
        try {
            Query query = entityManager.createQuery("FROM UserEntity o WHERE o.id = :t");
            query.setParameter("t", id);
            UserEntity user = (UserEntity) query.getSingleResult();

            UserBean Beanuser = user.toBean();

            return Beanuser;

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
            UserEntity user = (UserEntity) query.getSingleResult();

            UserBean Beanuser = user.toBean();

            return Beanuser;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
