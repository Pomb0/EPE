package JPA.Entities;

import javax.persistence.*;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*0: Shrubs , 1 : Trees , 2 : Seeds */
	@ManyToOne
	private PlantsEntity planta;

	@Column(nullable = false)
	private int stock;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String productCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
