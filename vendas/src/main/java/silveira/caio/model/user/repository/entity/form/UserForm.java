package silveira.caio.model.user.repository.entity.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserForm {

	private String name;
	private String login;
	private String password;
	private String locale;
}
