package silveira.caio.model.order.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silveira.caio.model.client.repository.entity.Client;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idpayment", referencedColumnName = "id")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;
	
	
	@PrePersist
	public void prePersist() {
		this.setDate(LocalDateTime.now());
	}
}
