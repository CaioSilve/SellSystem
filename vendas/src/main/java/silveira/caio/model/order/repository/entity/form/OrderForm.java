package silveira.caio.model.order.repository.entity.form;

import java.time.LocalDateTime;

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
public class OrderForm {

	
	private LocalDateTime date;
	private PaymentForm payment;
	private String clientName;
}
