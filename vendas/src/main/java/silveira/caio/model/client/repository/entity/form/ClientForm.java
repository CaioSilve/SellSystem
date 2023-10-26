package silveira.caio.model.client.repository.entity.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {

	@NotNull(message = "{field.name.required}")
	private String name;
	@CPF(message = "{field.cpf.invalid}")
	private String cpf;
	private LocalDate birthDate;
	private LocalDate registerDate;
}
