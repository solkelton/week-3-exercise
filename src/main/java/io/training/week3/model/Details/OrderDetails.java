package io.training.week3.model.Details;

import io.training.week3.model.Result.AddressResult;
import io.training.week3.model.Shipment;
import org.springframework.stereotype.Component;

@Component
public class OrderDetails {

  private Long orderNumber;
  private AddressResult shippingAddress;
  private Double totalPrice;
  private String productName;
  private Shipment shipment;

  public OrderDetails() {}

  public OrderDetails(Long orderNumber, Double totalPrice) {
    this.orderNumber = orderNumber;
    this.totalPrice = totalPrice;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public AddressResult getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(AddressResult shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Shipment getShipment() {
    return shipment;
  }

  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
  }
}
