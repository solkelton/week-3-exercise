package io.training.week3.model;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {

  @Id
  @GeneratedValue
  private long id;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="accountId")
  private Account account;

  private long orderNumber;
  private Timestamp orderDate;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="shippingId")
  private Address shippingAddress;

  @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="orderLineItemsId")
  private OrderLineItems orderLineItems;

  private double totalPrice;

  public Orders() {}

  public long getId() { return id; }

  public void setId(long id) {
    this.id = id;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

    public OrderLineItems getOrderLineItems() {
    return orderLineItems;
  }

  public void setOrderLineItems(OrderLineItems orderLineItems) {
    this.orderLineItems = orderLineItems;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
