package silveira.caio.model.client.repository.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.configs.DBMessageSource;
import silveira.caio.model.commons.ColumnsView;
import silveira.caio.model.commons.View;
import silveira.caio.model.commons.enums.ButtonEnum;

@Service
public class ViewClientService {
	
	@Autowired
	private DBMessageSource messageSource;

	public View generateView() {
		return View.builder().title("Client").description("Register").registered("Clients Registered").filter("Filter")
				.fields(generateFields()).buttons(generateButtons()).columns(generateColumns()).build();
	}

	private List<ColumnsView> generateColumns() {
		return Arrays.asList(ColumnsView.builder()
				.title(messageSource.getMessage("field.name"))
				.prop("name")
				.position(1)
				.build(),
				ColumnsView.builder()
				.title("CPF")
				.prop("cpf")
				.position(2)
				.build(),
				ColumnsView.builder()
				.title(messageSource.getMessage("field.birthDate"))
				.prop("birthDate")
				.position(3)
				.build());
	}

	private Map<String, String> generateButtons() {
		HashMap<String, String> map = new HashMap<>();
		map.put("save", messageSource.getMessage(ButtonEnum.SAVE.getValue()));
		map.put("clear", messageSource.getMessage(ButtonEnum.CLEAR.getValue()));
		map.put("alter", messageSource.getMessage(ButtonEnum.ALTER.getValue()));
		map.put("delete", messageSource.getMessage(ButtonEnum.DELETE.getValue()));
		map.put("find", messageSource.getMessage(ButtonEnum.FIND.getValue()));
		return map;
	}

	private Map<String, String> generateFields() {
		HashMap<String, String> map = new HashMap<>();
		map.put("registerDate", messageSource.getMessage("field.registerDate"));
		map.put("birthDate", messageSource.getMessage("field.birthDate"));
		map.put("name", messageSource.getMessage("field.name"));
		return map;
	}
}
