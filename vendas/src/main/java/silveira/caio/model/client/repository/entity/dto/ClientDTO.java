package silveira.caio.model.client.repository.entity.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDTO {

	private Long id;
	private String name;
	private String cpf;
	private LocalDate birthDate;
	private LocalDate registerDate;
	
}
