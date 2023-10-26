package silveira.caio.model.commons.enums;

import lombok.Getter;

@Getter
public enum ButtonEnum {

	SAVE("button.save"),
	CLEAR("button.clear"),
	ALTER("button.alter"),
	DELETE("button.delete"),
	FIND("button.find");
	
	private String value;
	
	private ButtonEnum(String value) {
		this.value = value;
	}
}
