package silveira.caio.model.order.repository.entity.form;

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
public class PaymentForm {

	private String paymentForm;
	private Integer installmentTotal;
	private Integer installmentPaids;
	private Double value;
	private Double discount;
}
