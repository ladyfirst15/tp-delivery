package myProject_LSP;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long>{

    ///Optional<Delivery> findByOrderId(Long orderId);
}