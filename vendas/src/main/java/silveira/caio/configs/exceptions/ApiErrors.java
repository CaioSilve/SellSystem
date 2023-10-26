package silveira.caio.configs.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class ApiErrors {

	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}
}
