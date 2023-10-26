package silveira.caio.configs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import silveira.caio.configs.exceptions.ApiErrors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiErrors handleValidation(MethodArgumentNotValidException ex) {
		BindingResult br = ex.getBindingResult();
		List<String> errors = br.getAllErrors().stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		return new ApiErrors(errors);
	}

	@ExceptionHandler(ResponseStatusException.class)
	ResponseEntity<ApiErrors> handleResponseStatus(ResponseStatusException ex) {
		return new ResponseEntity<ApiErrors>(new ApiErrors(ex.getReason()), ex.getStatusCode());
	}
}
