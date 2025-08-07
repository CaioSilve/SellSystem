package silveira.caio.model.commons.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silveira.caio.model.commons.view.repository.entity.View;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViewForm<T> {
	
	private View view;
	private T data;
}
