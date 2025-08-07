package silveira.caio.model.city.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_city")
	@SequenceGenerator(name = "seq_city", sequenceName = "seq_city")
	private Long id;
	private String name;

}
