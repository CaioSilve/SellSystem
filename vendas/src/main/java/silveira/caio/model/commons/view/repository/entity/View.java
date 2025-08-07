package silveira.caio.model.commons.view.repository.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silveira.caio.model.commons.view.repository.entity.table.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@jakarta.persistence.Table(name = "views")
public class View {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String keyView;
	private String name;
	@OneToMany
	@JoinColumn(name = "idview")
	private List<Row> rows;
	@OneToMany
	@JoinColumn(name = "idview")
	private List<Button> buttons;
	@ElementCollection
	private List<String> keyListMessages;
	@Transient
	private Map<String, String> messages;
	@OneToOne
	@JoinColumn(name = "idtable")
	private Table table;
}
