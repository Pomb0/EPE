package DataBean;

import java.io.Serializable;

/**
 * Created by Jaime on 30/03/2015.
 *
 */
public class UserBean implements Serializable{
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public UserBean setId(final int id) {
		this.id = id;
		return this;
	}

	public UserBean setUsername(final String username) {
		this.username = username;
		return this;
	}

	public UserBean setPassword(final String password) {
		this.password = password;
		return this;
	}


}
