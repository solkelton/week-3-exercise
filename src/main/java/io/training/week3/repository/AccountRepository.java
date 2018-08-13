package io.training.week3.repository;

import io.training.week3.model.Account;
import io.training.week3.model.results.OrderDetails;
import io.training.week3.model.results.ShipmentDetails;
import io.training.week3.model.results.OrdersDisplay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Query(nativeQuery = true, name="retrieveAccountOrders")
  List<OrdersDisplay> retrieveAccountOrders(long id);

  @Query(nativeQuery = true, name="retrieveOrderDetails")
  List<OrderDetails> retrieveOrderDetails(long id);

  @Query(nativeQuery = true, name="retrieveShipmentDetails")
  List<ShipmentDetails> retrieveShipmentDetails(long id);
}
