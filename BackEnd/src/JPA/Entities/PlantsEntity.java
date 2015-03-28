package JPA.Entities;

import javax.persistence.*;

@Entity
public class PlantsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private String type;
}
