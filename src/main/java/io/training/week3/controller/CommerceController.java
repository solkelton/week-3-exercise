package io.training.week3.controller;

import io.training.week3.model.Details.OrderDetails;
import io.training.week3.model.Result.OrdersResult;
import io.training.week3.model.Details.ShipmentDetails;
import io.training.week3.repository.AccountRepository;
import io.training.week3.repository.AddressRepository;
import io.training.week3.repository.OrderLineItemsRepository;
import io.training.week3.repository.OrdersRepository;
import io.training.week3.repository.ProductRepository;
import io.training.week3.repository.ShipmentRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** BRANCH 2 **/

@RestController
@RequestMapping("/accounts")
public class CommerceController {

  public final AccountRepository accountRepository;
  public final AddressRepository addressRepository;
  public final OrderLineItemsRepository orderLineItemsRepository;
  public final OrdersRepository ordersRepository;
  public final ProductRepository productRepository;
  public final ShipmentRepository shipmentRepository;
  public final OrderDetails orderDetails;
  public final ShipmentDetails shipmentDetails;

  public CommerceController(AccountRepository accountRepository,
      AddressRepository addressRepository,
      OrderLineItemsRepository orderLineItemsRepository,
      OrdersRepository ordersRepository,
      ProductRepository productRepository,
      ShipmentRepository shipmentRepository, OrderDetails orderDetails,
      ShipmentDetails shipmentDetails) {
    this.accountRepository = accountRepository;
    this.addressRepository = addressRepository;
    this.orderLineItemsRepository = orderLineItemsRepository;
    this.ordersRepository = ordersRepository;
    this.productRepository = productRepository;
    this.shipmentRepository = shipmentRepository;
    this.orderDetails = orderDetails;
    this.shipmentDetails = shipmentDetails;
  }

  @GetMapping("/{id}/orders")
  public List<OrdersResult> retrieveAccountOrders(@PathVariable long id) {
    return accountRepository.retrieveAccountOrders(id);
  }

  @GetMapping("/{accountId}/orders/{ordersId}/details")
  public OrderDetails retrieveOrderDetails(@PathVariable long accountId, @PathVariable long ordersId) {
    orderDetails.setOrderNumber(accountRepository.retrieveOrderNumber(accountId, ordersId));
    orderDetails.setShippingAddress(accountRepository.retrieveOrderAddress(accountId, ordersId));
    orderDetails.setTotalPrice(accountRepository.retrieveOrderPrice(accountId, ordersId));
    orderDetails.setProductName(accountRepository.retrieveProductName(accountId, ordersId));
//    orderDetails.setShipment(accountRepository.retrieveProductShipment(accountId, ordersId));
    return orderDetails;
  }

  @GetMapping("/{accountId}/orders/{ordersId}/shipments")
  public ShipmentDetails retrieveShipmentDetails(@PathVariable long accountId, @PathVariable long ordersId) {
    shipmentDetails.setOrderNumber(accountRepository.retrieveOrderNumber(accountId, ordersId));
    shipmentDetails.setShipmentDate(accountRepository.retrieveShipmentDate(accountId, ordersId));
    shipmentDetails.setDeliveryDate(accountRepository.retrieveDeliveryDate(accountId, ordersId));
    shipmentDetails.setProductName(accountRepository.retrieveProductName(accountId, ordersId));
    shipmentDetails.setQuantity(accountRepository.retrieveProductQuantity(accountId, shipmentDetails.getOrderNumber()));
    return shipmentDetails;
  }
}
