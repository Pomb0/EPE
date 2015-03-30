package JPA.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PlantsEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private String type;
}
