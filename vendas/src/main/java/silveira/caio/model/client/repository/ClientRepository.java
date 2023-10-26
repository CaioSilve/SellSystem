package silveira.caio.model.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.model.client.repository.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
