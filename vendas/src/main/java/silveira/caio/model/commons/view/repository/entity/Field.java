package silveira.caio.model.commons.view.repository.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Entity
@Table(name = "fields_view")
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String keyField;
	private Integer orderField;
	@Transient
	private String title;
	private String prop;
	private String type;
	private String styleClass;
	private String styleFindClass;
	private String mask;
	@OneToMany
	@JoinColumn(name = "idfield")
	private List<LabelValidation> listValidationLabels;
	private Boolean readonly;
	private Boolean active;
}
