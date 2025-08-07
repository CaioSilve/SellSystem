package silveira.caio.model.commons.enums;

import lombok.Getter;

@Getter
public enum LocaleEnum {

	EN("en"),
	PT("pt"),
	ES("es")
	
	;
	
	
	private String value;
	
	private LocaleEnum(String value) {
		this.value = value;
	}
}
