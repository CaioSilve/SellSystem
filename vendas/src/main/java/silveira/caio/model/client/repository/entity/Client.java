package silveira.caio.model.client.repository.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silveira.caio.model.city.repository.entity.City;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
	@SequenceGenerator(name = "seq_client", sequenceName = "seq_client")
	private Long id;
	private String name;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	private LocalDate birthDate;
	private LocalDate registerDate;
	private String email;
	private String cellphone;
	private Boolean sendPromotions;
	@ManyToOne
	@JoinColumn(name = "idcity")
	private City city;
	private String address;
	private String numberAddress;
	private String district;
	private String observation;

	@PrePersist
	private void prePersist() {
		this.setRegisterDate(LocalDate.now());
	}
}
