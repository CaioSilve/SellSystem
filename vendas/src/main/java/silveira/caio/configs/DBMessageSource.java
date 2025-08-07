package silveira.caio.configs;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import silveira.caio.configs.entity.MessageEntity;
import silveira.caio.configs.entity.repository.MessageRepository;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

	@Autowired
	private MessageRepository messageRepository;
	private static final String DEFAULT_LOCALE_CODE = Locale.ENGLISH.toString().split("_")[0];

	@Override
	public MessageFormat resolveCode(String key, Locale locale) {
		MessageEntity message = messageRepository.findByKeyMessageAndLocale(key, locale.toString().split("_")[0]);
		if (Objects.isNull(message))
			message = messageRepository.findByKeyMessageAndLocale(key, DEFAULT_LOCALE_CODE);
		return new MessageFormat(Objects.isNull(message) ? "" : message.getMessageContent(), locale);
	}

	public String getMessage(String key) {
		return this.resolveCode(key, Locale.ENGLISH).toPattern();
	}
}
