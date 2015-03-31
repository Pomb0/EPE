package EJBInterface;

import DataBean.UserBean;

import javax.ejb.Remote;

/**
 * Created by Jaime on 27/03/2015.
 *
 * This interface defines the methods for user manipulation
 * specificaly creation and login.
 *
 */

@Remote
public interface UserEJBInterface {
	// Define the possible responses of user creation
	enum UserCreationResult{
		OK(1), DUPLICATE_USER(2), UNKNOWN(4);
		private int value;
		UserCreationResult(int value) {
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}

	//Creates user, returns enum UserCreationResult
	UserCreationResult createUser(String username, String password);

	//Authenticates a user, returns true if authentication success, else, false.
	UserBean authenticate(String username, String password);

	UserBean getUser(int id);

	UserBean getUser(String username);
}
