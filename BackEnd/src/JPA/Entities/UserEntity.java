package JPA.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jaime on 27/03/2015.
 *
 */

@Entity
public class UserEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
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

	public UserEntity setUsername(final String username) {
		this.username = username;
		return this;
	}

	public UserEntity setPassword(final String password) {
		this.password = password;
		return this;
	}


}
