package silveira.caio.model.order.repository.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

	
	private Long id;
	private String paymentForm;
	private Integer installmentTotal;
	private Integer installmentPaids;
	private Double value;
	private Double discount;
}
