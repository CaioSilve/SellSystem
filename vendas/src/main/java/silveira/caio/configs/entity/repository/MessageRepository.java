package silveira.caio.configs.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.configs.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long>{

	MessageEntity findByKeyMessageAndLocale(String key, String locale);
}
