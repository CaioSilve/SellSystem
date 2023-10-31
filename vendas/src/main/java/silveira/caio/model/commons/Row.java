package silveira.caio.model.commons;

import java.util.List;

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
public class Row {

	private Integer order;
	private String styleClass;
	private String condition;
	private List<Field> fields;

}
