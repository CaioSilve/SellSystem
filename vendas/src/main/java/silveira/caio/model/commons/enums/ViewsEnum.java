package silveira.caio.model.commons.enums;

import lombok.Getter;

@Getter
public enum ViewsEnum {

	CLIENT("view.client"),
	USER("view.user"),
	
	;
	
	
	private String value;
	
	private ViewsEnum(String value) {
		this.value = value;
	}
}
