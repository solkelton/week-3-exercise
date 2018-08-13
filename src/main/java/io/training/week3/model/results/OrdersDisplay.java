package io.training.week3.model.results;

import java.math.BigInteger;
import java.util.Date;

public class OrdersDisplay {

  private Date orderDate;
  private BigInteger orderNumber;
  private Double totalPrice;


  public OrdersDisplay() {}

  public OrdersDisplay(Date orderDate, BigInteger orderNumber, Double totalPrice) {
    this.orderDate = orderDate;
    this.orderNumber = orderNumber;
    this.totalPrice = totalPrice;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public BigInteger getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(BigInteger orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
