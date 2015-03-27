package JPA.Entities;

import javax.persistence.*;

/**
 * Created by Jaime on 27/03/2015.
 *
 */

@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;


}
