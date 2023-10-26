package silveira.caio.model.order.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silveira.caio.model.order.repository.enums.EnumPaymentForm;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private EnumPaymentForm paymentForm;
	private Integer installmentTotal;
	private Integer installmentPaids;
	private Double value;
	private Double discount;
	
}
