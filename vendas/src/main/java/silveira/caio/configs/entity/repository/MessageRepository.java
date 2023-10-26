package silveira.caio.configs.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.configs.entity.LanguageEntity;

@Repository
public interface MessageRepository extends JpaRepository<LanguageEntity, Long>{

	LanguageEntity findByKeyAndLocale(String key, String locale);
}
