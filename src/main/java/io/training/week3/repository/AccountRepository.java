package io.training.week3.repository;

import io.training.week3.model.Account;
import io.training.week3.model.Result.AddressResult;
import io.training.week3.model.Result.OrdersResult;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Query(nativeQuery = true, name="retrieveAccountOrders")
  List<OrdersResult> retrieveAccountOrders(long accountId);

  @Query(value="select order_number from orders where account_id = ?1 and id = ?2", nativeQuery = true)
  Long retrieveOrderNumber(long accountId, long ordersId);

  @Query(value="select total_price from orders where account_id = ?1 and id = ?2", nativeQuery = true)
  Double retrieveOrderPrice(long accountId, long ordersId);

  @Query(nativeQuery = true, name="retrieveShippingAddress")
  AddressResult retrieveOrderAddress(long accountId, long ordersId);

  @Query(value="select name from product where id = ("
      + "select product_id from order_line_items where id = ("
      + "select  order_line_items_id from orders where account_id = ?1 and id = ?2)"
      + ")", nativeQuery = true)
  String retrieveProductName(long accountId, long ordersId);

  @Query(value="select date(shipped_date) from shipment where id = "
      + "(select shipment_id from order_line_items where id = ("
      + "select order_line_items_id from orders where account_id = 2 and id = 6))", nativeQuery = true)
  Date retrieveShipmentDate(long accountId, long ordersId);

  @Query(value="select date(delivery_date) from shipment where id = "
      + "(select shipment_id from order_line_items where id = ("
      + "select order_line_items_id from orders where account_id = 2 and id = 6))", nativeQuery = true)
  Date retrieveDeliveryDate(long accountId, long ordersId);

  @Query(value="select quantity from order_line_items where id = ("
      + "select order_line_items_id from orders where account_id = ?1 and order_number = ?2)", nativeQuery = true)
  int retrieveProductQuantity(long accountId, long orderNumber);

}
