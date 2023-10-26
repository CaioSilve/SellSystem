package silveira.caio.model.order.repository.enums;

import java.util.Arrays;
import java.util.Optional;

public enum EnumPaymentForm {

	DINHEIRO("dinheiro"), CARTAO_CREDITO("cartao_credito"), CARTAO_DEBITO("cartao_debito"), PIX("pix")

	;

	private String forma;

	EnumPaymentForm(String forma) {
		this.forma = forma;
	}

	public String getForma() {
		return forma;
	}

	public static Optional<EnumPaymentForm> get(String forma) {
		return Arrays.stream(EnumPaymentForm.values()).filter(f -> f.getForma().equalsIgnoreCase(forma)).findFirst();
	}
}
