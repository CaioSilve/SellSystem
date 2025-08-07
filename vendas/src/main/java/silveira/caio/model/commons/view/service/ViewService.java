package silveira.caio.model.commons.view.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.configs.DBMessageSource;
import silveira.caio.model.commons.view.repository.ViewRepository;
import silveira.caio.model.commons.view.repository.entity.View;

@Service
public class ViewService {

	@Autowired
	private ViewRepository repository;

	@Autowired
	private DBMessageSource messageSource;

	public View generateView(String keyView) {

		View view = repository.findByKeyView(keyView);

		view.getRows().stream().forEach(r -> r.getFields().stream().forEach(f -> {
			String titleMessage = messageSource.getMessage(f.getKeyField());

			f.setTitle(titleMessage.isEmpty() ? f.getProp() : titleMessage);
		}));

		view.getButtons().stream().forEach(b -> b.setTitle(messageSource.getMessage(b.getKeyButton())));

		view.setMessages(generateMessages(view.getKeyListMessages()));

		view.getTable().setPageSize(Arrays.asList(view.getTable().getPageSizes().split(", ")).stream()
				.map(p -> Integer.parseInt(p)).collect(Collectors.toList()));

		view.getTable().getColumns().stream().forEach(c -> c.setTitle(messageSource.getMessage(c.getKeyColumn())));

		return view;
	}

	private Map<String, String> generateMessages(List<String> keyListMessages) {
		Map<String, String> map = new HashMap<>();
		keyListMessages.forEach(k -> map.put(k.substring(k.lastIndexOf(".") + 1), messageSource.getMessage(k)));
		return map;
	}
}
