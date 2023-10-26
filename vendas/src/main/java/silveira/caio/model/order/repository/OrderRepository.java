package silveira.caio.model.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.model.order.repository.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
