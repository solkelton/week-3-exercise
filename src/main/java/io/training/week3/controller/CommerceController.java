package io.training.week3.controller;

import io.training.week3.model.results.OrderDetails;
import io.training.week3.model.results.OrdersDisplay;
import io.training.week3.model.results.ShipmentDetails;
import io.training.week3.repository.AccountRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class CommerceController {

  public final AccountRepository accountRepository;

  public CommerceController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/{id}/orders")
  public List<OrdersDisplay> retrieveAccountOrders(@PathVariable long id) {
    return accountRepository.retrieveAccountOrders(id);
  }

  @GetMapping("/{id}/orders/details")
  public List<OrderDetails> retrieveOrderDetails(@PathVariable long id) {
    return accountRepository.retrieveOrderDetails(id);
  }

  @GetMapping("/{id}/orders/shipment")
  public List<ShipmentDetails> retrieveShipmentDetails(@PathVariable long id) {
    return accountRepository.retrieveShipmentDetails(id);
  }
}
