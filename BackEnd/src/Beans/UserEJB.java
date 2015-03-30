package Beans;

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
    public boolean authenticate(String username, String password) {
        Query q = entityManager.createQuery("from UserEntity u where u.username = :t") ;
        q.setParameter("t", username);
        @SuppressWarnings("unchecked")
        List<UserEntity> result = q.getResultList();


        if(result.isEmpty())
            return false;

        Users temp = result.get(0);

        if(temp.getPassword().equals(Password))

            return temp;
        else
            return "Wrong Password";
        return false;
    }
}
