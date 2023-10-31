package silveira.caio.model.client.repository.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.configs.DBMessageSource;
import silveira.caio.model.commons.ColumnsView;
import silveira.caio.model.commons.Field;
import silveira.caio.model.commons.Row;
import silveira.caio.model.commons.View;
import silveira.caio.model.commons.enums.ButtonEnum;

@Service
public class ViewClientService {

	@Autowired
	private DBMessageSource messageSource;

	public View generateView() {
		// fazer consulta na base

		return View.builder().key("view.Client").title("Client").description("Register")
				.registered("Clients Registered").filter("Filter").rows(generateRows()).fields(generateFields())
				.buttons(generateButtons()).columns(generateColumns()).build();
	}

	private List<Row> generateRows() {
		return Arrays
				.asList(Row.builder().order(1).condition("clientForm.value.id")
						.fields(Arrays.asList(
								Field.builder().id("id").order(1).row(1).title("ID").type("text").readonly(true)
										.styleClass("col-md-1 col-sm-2 col-4").build(),
								Field.builder().id("registerDate")
										.title(messageSource.getMessage("field." + "registerDate")).type("date")
										.readonly(false).styleClass("col-md-2 col-sm-4 col-6").build()))
						.build(),
						Row.builder().order(2).fields(Arrays.asList(
								Field.builder().id("name").title(messageSource.getMessage("field." + "name"))
										.type("text").readonly(false).styleClass("col-md-3 col-sm-6 col-12").build(),
								Field.builder().id("cpf").title("CPF").type("text").mask("cpfMask").readonly(false)
										.styleClass("col-md-2 col-sm-4 col-6").build(),
								Field.builder().id("birthDate").title(messageSource.getMessage("field." + "birthDate"))
										.type("date").readonly(false).styleClass("col-md-2 col-sm-4 col-6").build()))
								.build());
	}

	private List<ColumnsView> generateColumns() {

		// TODO base
		return Arrays.asList(
				ColumnsView.builder().title(messageSource.getMessage("field.name")).prop("name").position(1).build(),
				ColumnsView.builder().title("CPF").prop("cpf").position(2).build(), ColumnsView.builder()
						.title(messageSource.getMessage("field.birthDate")).prop("birthDate").position(3).build(), ColumnsView.builder()
						.title(messageSource.getMessage("field.registerDate")).prop("registerDate").position(4).build());
	}

	private Map<String, String> generateButtons() {
		HashMap<String, String> map = new HashMap<>();

		// TODO base
		map.put("save", messageSource.getMessage(ButtonEnum.SAVE.getValue()));
		map.put("clear", messageSource.getMessage(ButtonEnum.CLEAR.getValue()));
		map.put("alter", messageSource.getMessage(ButtonEnum.ALTER.getValue()));
		map.put("delete", messageSource.getMessage(ButtonEnum.DELETE.getValue()));
		map.put("find", messageSource.getMessage(ButtonEnum.FIND.getValue()));
		return map;
	}

	private Map<String, String> generateFields() {
		HashMap<String, String> map = new HashMap<>();

		// TODO base
		map.put("registerDate", messageSource.getMessage("field.registerDate"));
		map.put("birthDate", messageSource.getMessage("field.birthDate"));
		map.put("name", messageSource.getMessage("field.name"));
		map.put("filter", messageSource.getMessage("field.filter"));
		return map;
	}
}
