package silveira.caio.configs;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import silveira.caio.configs.entity.LanguageEntity;
import silveira.caio.configs.entity.repository.MessageRepository;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

	@Autowired
	private MessageRepository messageRepository;
	private static final String DEFAULT_LOCALE_CODE = "en";

	@Override
	public MessageFormat resolveCode(String key, Locale locale) {
		LanguageEntity message = messageRepository.findByKeyAndLocale(key, locale.getLanguage());
		if (Objects.isNull(message)) 
			message = messageRepository.findByKeyAndLocale(key, DEFAULT_LOCALE_CODE);
		return new MessageFormat(Objects.isNull(message) ? "Error" : message.getContent(), locale);
	}
	
	public String getMessage(String key) {
		return this.resolveCode(key, Locale.ENGLISH).toPattern();
	}
}
