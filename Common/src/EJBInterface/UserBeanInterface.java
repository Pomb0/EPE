package EJBInterface;

import javax.ejb.Remote;

/**
 * Created by Jaime on 27/03/2015.
 *
 * This interface defines the methods for user manipulation
 * specificaly creation and login.
 *
 */

@Remote
public interface UserBeanInterface {
	// Define the possible responses of user creation
	enum UserCreationResult{
		OK(1), DUPLICATE_USER(2), DUPLICATE_MAIL(3), UNKNOWN(4);
		private int value;
		private UserCreationResult(int value) {
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}

	//Creates user, returns enum UserCreationResult
	UserCreationResult createUser(String username, String password);

	//Authenticates a user, returns true if authentication success, else, false.
	boolean authenticate(String username, String password);
}
