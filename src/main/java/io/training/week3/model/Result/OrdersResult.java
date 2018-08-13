package io.training.week3.model.Result;

import java.math.BigInteger;
import java.util.Date;

public class OrdersResult {

  private BigInteger id;
  private Date orderDate;
  private BigInteger orderNumber;
  private Double totalPrice;
  private BigInteger accountId;
  private BigInteger orderLineItemsId;
  private BigInteger shippingId;

  public OrdersResult(BigInteger id, Date orderDate, BigInteger orderNumber, Double totalPrice,
      BigInteger accountId, BigInteger orderLineItemsId, BigInteger shippingId) {
    this.id = id;
    this.orderDate = orderDate;
    this.orderNumber = orderNumber;
    this.totalPrice = totalPrice;
    this.accountId = accountId;
    this.orderLineItemsId = orderLineItemsId;
    this.shippingId = shippingId;
  }

  public OrdersResult() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
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

  public BigInteger getAccountId() {
    return accountId;
  }

  public void setAccountId(BigInteger accountId) {
    this.accountId = accountId;
  }

  public BigInteger getOrderLineItemsId() {
    return orderLineItemsId;
  }

  public void setOrderLineItemsId(BigInteger orderLineItemsId) {
    this.orderLineItemsId = orderLineItemsId;
  }

  public BigInteger getShippingId() {
    return shippingId;
  }

  public void setShippingId(BigInteger shippingId) {
    this.shippingId = shippingId;
  }
}
