package io.training.week3.repository;

import io.training.week3.model.Account;
import io.training.week3.model.Address;
import io.training.week3.model.OrderLineItems;
import io.training.week3.model.Orders;
import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
