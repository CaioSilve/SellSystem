package silveira.caio.model.commons;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class View {

	private String key;
	private String title;
	private String description;
	private String registered;
	private String filter;
	private List<Row> rows;
	// identificar dps se é possivel usar apenas a row
	private Map<String, String> fields;
	private Map<String, String> buttons;
	private List<ColumnsView> columns;
}
