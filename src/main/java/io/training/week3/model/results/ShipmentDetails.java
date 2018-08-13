package io.training.week3.model.results;

import java.math.BigInteger;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ShipmentDetails {

  private BigInteger orderNumber;
  private Date shipmentDate;
  private Date deliveryDate;
  private String productName;
  private int quantity;

  public ShipmentDetails(BigInteger orderNumber, Date shipmentDate, Date deliveryDate,
      String productName, int quantity) {
    this.orderNumber = orderNumber;
    this.shipmentDate = shipmentDate;
    this.deliveryDate = deliveryDate;
    this.productName = productName;
    this.quantity = quantity;
  }

  public ShipmentDetails() {}

  public BigInteger getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(BigInteger orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getShipmentDate() {
    return shipmentDate;
  }

  public void setShipmentDate(Date shipmentDate) {
    this.shipmentDate = shipmentDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
