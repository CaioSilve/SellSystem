package silveira.caio.model.commons.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.model.commons.view.repository.entity.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {

	
	public View findByKeyView(String key);
}
