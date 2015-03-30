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


	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public PlantsEntity setType(final String type) {
		this.type = type;
		return this;
	}


}
